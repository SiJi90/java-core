package com.example.chapter01.test.t4;

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
        MyThread d = new MyThread("D");
        MyThread e = new MyThread("E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
