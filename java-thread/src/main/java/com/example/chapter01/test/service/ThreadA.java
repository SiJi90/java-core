package com.example.chapter01.test.service;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/08
 */
public class ThreadA extends Thread {

    private HasSelfPrivateNum numRef;

    public ThreadA(HasSelfPrivateNum numRef) {
        this.numRef = numRef;
    }

    @Override
    public void run() {
        numRef.addI("a");
    }
}
