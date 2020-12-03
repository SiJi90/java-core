package com.example.chapter01.test.suspend_resume;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/07
 */
public class MyThread extends Thread {
    private Long i = 0L;

    public Long getI() {
        return i;
    }

    public void setI(Long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            i++;
        }
    }
}

class Run {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();

        Thread.sleep(1000);
        myThread.suspend();
        System.out.println(myThread.getI());

        myThread.resume();
        Thread.sleep(1000);

        myThread.suspend();
        System.out.println(myThread.getI());
        Thread.sleep(1000);

        System.out.println(myThread.getI());
        myThread.stop();
    }
}