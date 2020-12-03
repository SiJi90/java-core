package com.example.chapter01.test.t9;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/07
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        try {

            for (int i = 0; i < 100; i++) {
                if (Thread.interrupted()) {
                    System.out.println("线程停止，我要退出了");
                    throw new InterruptedException();
                }
                System.out.println("i = " + (i + 1));
                System.out.println("hhhhhhhhhhhh");

            }
        } catch (InterruptedException e) {

            System.out.println("线程真正被停止了");
        }
    }
}

class Run {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(1);
        thread.interrupt();
        System.out.println(Thread.currentThread().getName());
        System.out.println("线程是否中断：" + Thread.interrupted());
        //System.out.println("线程是否中断：" + Thread.interrupted());
        System.out.println("zzzzzzzzzzzzzzzzzzzzz");
    }
}