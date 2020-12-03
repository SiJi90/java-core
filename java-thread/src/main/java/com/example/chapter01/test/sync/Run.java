package com.example.chapter01.test.sync;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/08
 */
public class Run {

    public static void main(String[] args) {
        MyObject object = new MyObject();
        ThreadA a = new ThreadA(object);
        ThreadB b = new ThreadB(object);
        a.setName("A");
        b.setName("B");

        a.start();
        b.start();
    }
}
