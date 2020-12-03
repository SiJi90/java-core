package com.example.io.tcp.demo1;

import java.util.Optional;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/28
 */
public class TestOptional {
    public static void main(String[] args) {
        Optional<String> stringOptional = Optional.of("hello");

        String result = stringOptional.orElse("hello");
        System.out.println("result = " + result);

        String orElseGet = stringOptional.orElseGet(() -> "echo helloWorld");
        System.out.println("orElseGet = " + orElseGet);

        String orElseThrow = stringOptional.orElseThrow(RuntimeException::new);
        System.out.println("orElseThrow = " + orElseThrow);

        stringOptional.ifPresent(String::toUpperCase);

    }
}
