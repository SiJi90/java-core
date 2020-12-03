package com.example.chapter01.test.t7;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/06
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("run " + this.isAlive());
    }
}

class Run {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        System.out.println("begin " + thread.isAlive());
        thread.start();
        Thread.sleep(1000);
        System.out.println("end " + thread.isAlive());
    }
}
