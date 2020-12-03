package com.example.chapter01.test.daemon;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/07
 */
public class MyDaemonThread extends Thread {

    private int i = 0;

    @Override
    public void run() {
        while (true) {
            i++;
            System.out.println("i = " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Run {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread thread = new MyDaemonThread();
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(5000);
        System.out.println("main 线程运行结束，守护线程自动销毁");
    }
}