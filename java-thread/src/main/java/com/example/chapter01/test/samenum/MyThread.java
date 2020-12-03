package com.example.chapter01.test.samenum;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/06
 */
public class MyThread extends Thread {

    private int i = 5;

    @Override
    synchronized public void run() {
        i--;
        System.out.println("i=" + i + " threadName= " + Thread.currentThread().getName());
    }
}

class Run {
    public static void main(String[] args) {
        MyThread run = new MyThread();

        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);
        Thread t4 = new Thread(run);
        Thread t5 = new Thread(run);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
