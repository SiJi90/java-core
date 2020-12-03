package com.example.interfaces.demo;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author: slm
 */
public class EmployeeTest {

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        for (int i = 0; i < staff.length; i++) {
            staff[i] = new Employee("TEST" + i, 2000.0 + i);
        }

        Arrays.sort(staff);

        Stream.of(staff).forEach(System.out::print);
    }
}
