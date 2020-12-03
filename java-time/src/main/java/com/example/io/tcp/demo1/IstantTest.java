package com.example.io.tcp.demo1;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/05
 */
public class IstantTest {
    public static void main(String[] args) {
        Instant start = Instant.now();
        runAlgorithmA();
        Instant end = Instant.now();


        runAlgorithmB();

        //testTime(() -> runAlgorithmB());

    }


    public static void testTime(Consumer consumer) {
        //consumer.accept();
    }

    public static void runAlgorithmA() {
        int size = 10;
        List<Integer> list = new Random().ints().map(i -> i % 100).limit(size).boxed().collect(Collectors.toList());
        Collections.sort(list);
        System.out.println(list);
    }

    public static void runAlgorithmB() {
        int size = 10;
        List<Integer> list = new Random().ints().map(i -> i % 100).limit(size).boxed().collect(Collectors.toList());
        while (!IntStream.range(1, list.size()).allMatch(i -> list.get(i - 1).compareTo(list.get(i)) <= 0)) {
            Collections.shuffle(list);
            System.out.println(list);
        }
    }
}
