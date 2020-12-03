package com.example.chapter01.test.service;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/08
 */
public class HasSelfPrivateNum {

    private int num = 19;

    synchronized public void addI(String username) {
        try {
            if ("a".equals(username)) {
                num = 100;
                System.out.println("a set over!");
            } else {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println("username:" + username + "\tnum = " + num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
