package com.example.interfaces.lambad;

import java.util.function.Function;

/**
 * @author: slm
 */
public class LambdaTest {

    public static void main(String[] args) {
        test("hello", String::length);
    }

    public static <T, R> R test(T data, Function<T, R> consumer) {
        return consumer.apply(data);
    }
}
