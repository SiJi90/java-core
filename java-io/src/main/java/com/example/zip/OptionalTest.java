package com.example.zip;

import java.util.Optional;

/**
 * @author: slm
 */
public class OptionalTest {
    public static void main(String[] args) {
        System.out.println("Optional.ofNullable(null).orElse(\"hello\") = " + Optional.ofNullable(null).orElse("hello"));
        System.out.println("Optional.ofNullable(null).orElse(\"hello\") = " + Optional.ofNullable(null).orElse(true));

    }
}
