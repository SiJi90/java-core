package com.example.chapter01.test.t3;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/06
 */
public class MyThread extends Thread {

    private int count = 5;

    public MyThread(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由" + this.getName() + "计算， count=" + count);
        }
    }
}
