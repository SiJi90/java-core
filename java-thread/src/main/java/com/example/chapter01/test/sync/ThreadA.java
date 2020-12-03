package com.example.chapter01.test.sync;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/08
 */
public class ThreadA extends Thread {

    private MyObject object;

    public ThreadA(MyObject object) {
        this.object = object;

    }

    @Override
    public void run() {
        object.mthodA();
    }
}
