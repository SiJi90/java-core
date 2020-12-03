package com.example.chapter01.test.sync;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/08
 */
public class ThreadB extends Thread{

    private MyObject object;

    public ThreadB(MyObject object) {
        this.object = object;
    }
    @Override
    public void run() {
        object.mthodA();
    }
}
