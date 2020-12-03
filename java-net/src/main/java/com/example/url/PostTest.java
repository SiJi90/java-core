package com.example.url;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author: slm
 */
public class PostTest {
    public static void main(String[] args) throws Exception {
        String propsFileName = args.length > 0 ? args[0] : "post.properties";
        Properties props = new Properties();
        String filePath = PostTest.class.getClassLoader().getResource("").getPath() + propsFileName;
        System.out.println("filePath = " + filePath);
        try (InputStream in = new FileInputStream(filePath)) {
            props.load(in);
        } catch (Exception e) {

        }
        String url = props.get("url").toString();
        Object userAgent = props.get("User-Agent");
        Object redirects = props.get("redirects");
        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));

        doPost(new URL(url), props, userAgent.toString(), -1);
        System.out.println("url = " + url);
    }

    public static String doPost(URL url, Map<Object, Object> namValuePairs, String userAgent, int redirects) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        if (userAgent != null) {
            connection.setRequestProperty("User-Agent", userAgent);
        }
        if (redirects >= 0) {
            connection.setInstanceFollowRedirects(false);
        }

        connection.setDoOutput(true);

        try (PrintWriter pw = new PrintWriter(connection.getOutputStream())) {
            boolean first = true;
            for (Map.Entry<Object, Object> pair : namValuePairs.entrySet()) {
                if (first) {
                    first = false;
                } else {
                    pw.print('&');
                    String name = pair.getKey().toString();
                    String value = pair.getValue().toString();
                    pw.print(name);
                    pw.print('=');
                    pw.print(URLEncoder.encode(value, "UTF-8"));
                }
            }
            String encoding = connection.getContentEncoding();
            if (encoding == null) {
                encoding = "UTF-8";
            }
            if (redirects > 0) {
                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP || responseCode == HttpURLConnection.HTTP_SEE_OTHER) {
                    String location = connection.getHeaderField("Location");
                    if (location != null) {
                        URL base = connection.getURL();
                        connection.disconnect();
                        return doPost(new URL(base, location), namValuePairs, userAgent, redirects - 1);
                    }
                }

            } else if (redirects == 0) {
                throw new IOException("Too many redirects");
            }

            StringBuilder response = new StringBuilder();
            try (Scanner scanner = new Scanner(connection.getInputStream(), encoding)) {
                while (scanner.hasNextLine()) {
                    response.append(scanner.nextLine());
                    response.append("\n");
                }
            } catch (IOException e) {
                InputStream err = connection.getErrorStream();
                if (err == null) {
                    throw e;
                }
                try (Scanner scanner = new Scanner(err)) {
                    while (scanner.hasNextLine()) {
                        response.append(scanner.nextLine() + "\n");
                    }
                }
            }
            return response.toString();
        }
    }
}
