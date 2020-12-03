package com.example.chapter01.test.sync;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/08
 */
public class MyObject {

    synchronized public void mthodA() {
        try {
            System.out.println("begin methodA threadName = " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
