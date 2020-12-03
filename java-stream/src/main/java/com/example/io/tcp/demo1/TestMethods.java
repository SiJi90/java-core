package com.example.io.tcp.demo1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/28
 */
public class TestMethods {
    public static void main(String[] args) {
        List<Character> words = Arrays.asList('a', 'b', 'c', 'd');
        //words.stream().map(w -> w.toString() + "hello").forEach(System.out::println);
        //words.stream().map(w -> w.toString().toUpperCase()).forEach(System.out::println);

        // generate 生成一个无限流
        Stream<Double> randoms = Stream.generate(Math::random);
    }
}
