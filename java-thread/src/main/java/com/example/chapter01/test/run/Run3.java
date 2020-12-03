package com.example.chapter01.test.run;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/06
 */
public class Run3 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
