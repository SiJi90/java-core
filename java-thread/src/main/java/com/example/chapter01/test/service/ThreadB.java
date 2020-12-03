package com.example.chapter01.test.service;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/08
 */
public class ThreadB extends Thread {

    private HasSelfPrivateNum numRef;

    public ThreadB(HasSelfPrivateNum numRef) {
        this.numRef = numRef;
    }

    @Override
    public void run() {
        numRef.addI("b");
    }
}
