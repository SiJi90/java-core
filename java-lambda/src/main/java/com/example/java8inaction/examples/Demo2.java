package com.example.java8inaction.examples;

import com.example.java8inaction.entity.Dish;

/**
 * @author: slm
 */
public class Demo2 {
    public static void main(String[] args) {
        Integer sum = Dish.menu.stream().map(d -> 1).reduce(0, Integer::sum);
        System.out.println("sum = " + sum);
    }
}
