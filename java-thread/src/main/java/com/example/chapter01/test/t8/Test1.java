package com.example.chapter01.test.t8;

import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/06
 */
public class Test1 {

    public static void main(String[] args) {
        Test1 t = new Test1();
        t.a();
    }

    public void a() {
        b();
    }

    private void b() {
        c();
    }

    private void c() {
        d();
    }

    private void d() {
        e();
    }

    private void e() {
        // 1. 获取当前线程的堆栈跟踪信息
        //StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        //Stream.of(stackTrace).forEach(System.out::println);
        // 2. 将当前线程的堆栈跟踪信息输出至标准错误流
        //Thread.dumpStack();

        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        Iterator<Thread> iterator = allStackTraces.keySet().iterator();
        while (iterator.hasNext()) {
            Thread next = iterator.next();
            StackTraceElement[] stackTraceElements = allStackTraces.get(next);
            System.out.println("=============每个线程基本信息============");
            System.out.println("线程名称： " + next.getName());
            System.out.println("线程状态： " + next.isAlive());
            System.out.println("线程ID " + next.getId());
            Stream.of(stackTraceElements).forEach(System.out::println);
        }
    }
}
