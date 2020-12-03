package com.example.io.tcp.demo1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/29
 */
public class TextFileTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        for (int i = 0; i < staff.length; i++) {
            staff[i] = new Employee("张三" + i, i * 1000d, String.valueOf(i * 20 + 1900));
        }
        final String fileName = "employee.dat";
        try (PrintWriter out = new PrintWriter(fileName, StandardCharsets.UTF_8.toString())) {
            writeData(staff, out);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Scanner in = new Scanner(new FileInputStream(fileName), StandardCharsets.UTF_8.toString())) {
            Employee[] newStaff = readData(in);
            for (Employee employee : newStaff) {
                System.out.println("employee = " + employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeData(Employee[] employees, PrintWriter out) {
        out.println(employees.length);
        Stream.of(employees).forEach(e -> writeEmployee(out, e));
    }

    public static void writeEmployee(PrintWriter out, Employee e) {
        out.println(e.getName() + "|" + e.getSalary() + "|" + e.getHireDay());
    }

    public static Employee[] readData(Scanner in) {
        int n = in.nextInt();
        in.nextLine();


        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = readEmployee(in);
        }
        return employees;

    }

    public static Employee readEmployee(Scanner in) {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        Double salary = Double.parseDouble(tokens[1]);
        String hireDay = tokens[2];
        return new Employee(name, salary, hireDay);
    }

    static class Employee {
        private String name;
        private Double salary;
        private String hireDay;

        public Employee(String name, Double salary, String hireDay) {
            this.name = name;
            this.salary = salary;
            this.hireDay = hireDay;
        }

        @Override
        public String toString() {
            return "Employee{" + "name='" + name + '\'' + ", salary=" + salary + ", hireDay='" + hireDay + '\'' + '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        public String getHireDay() {
            return hireDay;
        }

        public void setHireDay(String hireDay) {
            this.hireDay = hireDay;
        }
    }

}
