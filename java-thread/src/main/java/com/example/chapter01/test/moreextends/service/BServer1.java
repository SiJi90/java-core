package com.example.chapter01.test.moreextends.service;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/06
 */
public class BServer1 extends AServer implements Runnable {

    public void bSaveMehod() {
        System.out.println("b中保存数据的方法被执行。。。");
    }

    @Override
    public void run() {
        bSaveMehod();
    }
}

class Run {
    public static void main(String[] args) {
        BServer1 server1 = new BServer1();
        Thread thread = new Thread(server1);
        thread.start();
    }
}