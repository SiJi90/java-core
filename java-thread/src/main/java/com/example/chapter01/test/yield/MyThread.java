package com.example.chapter01.test.yield;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/07
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        Long beginTime = System.currentTimeMillis();
        int i = 0;
        int count = 0;
        while (i < 5000000) {
            Thread.yield();
            i++;
            count = count + i;
        }

        Long endTime = System.currentTimeMillis();
        System.out.println("用时" + (endTime - beginTime) + "毫秒！");
    }
}

class Run {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
