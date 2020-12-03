package com.example.chapter01.test.t4_shreadsafe;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/06
 */
public class Run {
    public static void main(String[] args) {
        ALogin a = new ALogin();
        BLogin b = new BLogin();
        a.start();
        b.start();
    }
}
