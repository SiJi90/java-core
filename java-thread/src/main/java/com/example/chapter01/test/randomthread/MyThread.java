package com.example.chapter01.test.randomthread;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/06
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("run=" + Thread.currentThread().getName());
        }
    }
}

class Test {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.setName("myThread");
        thread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main=" + Thread.currentThread().getName());
        }
    }
}
