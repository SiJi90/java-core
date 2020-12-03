package com.example.chapter01.test.t4;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/06
 */
public class MyThread extends Thread {

    private static int count = 5;

    public MyThread(String name) {
        super();
        this.setName(name);
    }

    @Override
    public synchronized void run() {
        super.run();
        count--;
        System.out.println("由" + this.getName() + "计算， count=" + count);
    }
}
