package com.example.io.tcp.core.demo3;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;

/**
 * @description: URLConnection
 * @author: slm
 * @create: 2020/08/28
 */
public class URLConnectionTest {
    public static void main(String[] args) {
        try {
            String urlName;
            if (args.length > 0) {
                urlName = args[0];
            } else {
                urlName = "http://www.baidu.com";
            }

            URL url = new URL(urlName);
            URLConnection connection = url.openConnection();

            if (args.length > 2) {
                String username = args[1];
                String password = args[2];
                String input = username + ":" + password;
                Base64.Encoder encoder = Base64.getEncoder();
                String encoding = encoder.encodeToString(input.getBytes(StandardCharsets.UTF_8));
                connection.setRequestProperty("Authorization", "Basic " + encoding);
            }

            connection.connect();

            Map<String, List<String>> headerFields = connection.getHeaderFields();
            for (String s : headerFields.keySet()) {
                System.out.println(s + "=" + headerFields.get(s));
            }

            System.out.println("------------------");
            System.out.println("connection.getContentType() = " + connection.getContentType());
            System.out.println("connection.getContentLength() = " + connection.getContentLength());
            System.out.println("connection.getContentEncoding() = " + connection.getContentEncoding());
            System.out.println("connection.getDate() = " + connection.getDate());
            System.out.println("connection.getExpiration() = " + connection.getExpiration());
            System.out.println("connection.getLastModified() = " + connection.getLastModified());
            System.out.println("------------------");

            String encoding = connection.getContentEncoding();
            if (encoding == null) {
                encoding = "UTF-8";
               /* try (Scanner in = new Scanner(connection.getInputStream(), encoding)) {
                    for (int n = 1; in.hasNextLine() && n < 10; n++) {
                        System.out.println(in.nextLine());
                        if (in.hasNextLine()) {
                            System.out.println("...");
                        }
                    }
                }*/
                InputStream inputStream = connection.getInputStream();
                byte[] bytes = new byte[1024 * 10];
                int len = 0;
                if ((len = inputStream.read(bytes)) != -1) {
                    System.out.println(new String(bytes, 0, len, encoding));
                }
                inputStream.close();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
