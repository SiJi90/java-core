package com.example.chapter01.test.t4_shreadsafe;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/06
 */
public class BLogin extends Thread{
    @Override
    public void run() {
        LoginServlet.doPost("b","bb");
    }
}
