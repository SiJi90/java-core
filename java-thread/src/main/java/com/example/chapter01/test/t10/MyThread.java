package com.example.chapter01.test.t10;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/07
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("run begin");
            Thread.sleep(2000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("在睡眠中被停止！进入 catch " + this.isInterrupted());
            e.printStackTrace();
        }
    }
}

class Run {
    public static void main(String[] args) {
        MyThread thread = new MyThread();

        try {
            thread.start();
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        thread.stop();
        System.out.println("end...");
    }
}