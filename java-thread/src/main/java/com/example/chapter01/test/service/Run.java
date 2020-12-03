package com.example.chapter01.test.service;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/08
 */
public class Run {
    public static void main(String[] args) {
        HasSelfPrivateNum numRef1 = new HasSelfPrivateNum();
        HasSelfPrivateNum numRef2 = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(numRef1);


        ThreadB threadB = new ThreadB(numRef2);

        threadA.start();
        threadB.start();

    }
}
