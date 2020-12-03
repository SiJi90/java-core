package com.example.chapter01.test.t3;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/06
 */
public class Run {
    public static void main(String[] args) {
        MyThread a = new MyThread("A");
        MyThread b = new MyThread("B");
        MyThread c = new MyThread("C");
        a.start();
        b.start();
        c.start();
    }
}
