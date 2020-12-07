package com.example.java8inaction.examples;

import com.example.java8inaction.entity.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: slm
 */
public class Demo1 {

    public static void main(String[] args) {
        List<String> stringList = Dish.menu.stream().filter(d ->
        {
            System.out.println("filter :" + d.getName());
            return d.getCalories() > 300;
        }).map(d ->
        {
            System.out.println("mapping :" + d.getName());
            return d.getName();
        }).limit(3).collect(Collectors.toList());
        System.out.println("stringList = " + stringList);
        Dish.menu.stream().filter(Dish::isVegetarian).forEach(System.out::println);
        List<String> strings = Arrays.asList("java8", "In", "Action");
        strings.stream().map(s ->
        {
            System.out.println("===");
            return s.substring(1);
        }).forEach(System.out::print);

        strings.forEach(System.out::print);



    }
}
