package com.example.chapter01.test.t4_shreadsafe;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/06
 */
public class LoginServlet {
    private static String usernameRef;
    private static String passwordRef;

    public static synchronized void doPost(String username, String password) {
        try {
            usernameRef = username;
            if ("a".equals(username)) {
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println("username=" + usernameRef + "password=" + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
