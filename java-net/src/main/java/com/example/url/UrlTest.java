package com.example.url;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author: slm
 */
public class UrlTest {

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://cn.bing.com/search");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(connection.getOutputStream()), true);
        pw.print(String.format("q=%s&go=%s&qs=%s&form=%s", URLEncoder.encode("你好", "UTF-8"), URLEncoder.encode("提交", "UTF-8"), URLEncoder.encode("ds", "UTF-8"), URLEncoder.encode("QBLH", "UTF-8")));
        pw.close();
        //connection.setDoOutput(false);
        //connection.setDoInput(true);
        Scanner scanner = new Scanner(connection.getInputStream(), StandardCharsets.UTF_8.name());
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            System.out.print(s);
        }

    }
}
