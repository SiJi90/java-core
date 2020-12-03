package com.example.io.tcp.core.demo3;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/**
 * @description: 使用 URLConnection 发送 Post 请求
 * @author: slm
 * @create: 2020/08/28
 */
public class PostTest {
    public static void main(String[] args) throws Exception {
        final String fileName = "post.properties";
        String propsFileName = args.length > 0 ? args[0] : fileName;
        Properties props = new Properties();
        URI uri = PostTest.class.getClassLoader().getResource(fileName).toURI();
        try (InputStream inputStream = Files.newInputStream(Paths.get(uri))) {
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String urlSting = props.remove("url").toString();
        Object userAgent = props.remove("User-Agent");
        Object redirects = props.remove("redirects");


        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));

        String result = doPost(new URL(urlSting), props, userAgent == null ? null : userAgent.toString(), redirects == null ? -1 : Integer.parseInt(redirects.toString()));
        System.out.println("result = " + result);


    }

    /**
     * do an  HTTP POST
     *
     * @param url
     * @param nameValuePairs
     * @param userAgent
     * @param redirects
     * @return
     */
    public static String doPost(URL url, Map<Object, Object> nameValuePairs, String userAgent, int redirects) {
        HttpURLConnection connection = null;
        StringBuilder response = new StringBuilder();
        try {

            connection = (HttpURLConnection) url.openConnection();

            if (userAgent != null) {
                connection.setRequestProperty("User-Agent", userAgent);
            }

            if (redirects >= 0) {
                connection.setInstanceFollowRedirects(false);
            }

            connection.setDoOutput(true);

            try (PrintWriter out = new PrintWriter(connection.getOutputStream())) {
                boolean first = true;
                for (Map.Entry<Object, Object> pair : nameValuePairs.entrySet()) {
                    if (first) {
                        first = false;
                    } else {
                        out.println('&');
                    }
                    String name = pair.getKey().toString();
                    String value = pair.getValue().toString();
                    out.println(name);
                    out.println('=');
                    out.println(URLEncoder.encode(value, StandardCharsets.UTF_8.toString()));
                }
            }

            String encodeing = connection.getContentEncoding();
            if (encodeing == null) {
                encodeing = StandardCharsets.UTF_8.toString();
            }

            if (redirects > 0) {
                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP || responseCode == HttpURLConnection.HTTP_SEE_OTHER) {
                    String location = connection.getHeaderField("Location");
                    if (location != null) {
                        URL base = connection.getURL();
                        connection.disconnect();
                        return doPost(new URL(base, location), nameValuePairs, userAgent, redirects - 1);
                    }
                }
            } else if (redirects == 0) {
                throw new IOException("Too many redirects");
            }


            try (Scanner in = new Scanner(connection.getInputStream(), encodeing)) {
                while (in.hasNextLine()) {
                    response.append(in.nextLine());
                    response.append("\n");
                }
            }
        } catch (IOException e) {
            InputStream err = connection.getErrorStream();
            if (err == null) {

            }
            try (Scanner in = new Scanner(err)) {
                response.append(in.nextLine());
                response.append("\n");

            }
        }

        return response.toString();

    }
}
