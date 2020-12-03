package com.example.chapter01.test.t2;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/06
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在运行中。。。");
    }
}

class Run {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("运行结束");
    }
}
