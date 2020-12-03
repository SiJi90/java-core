package com.example.io.tcp.demo1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/29
 */
public class RandomAccessTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000D, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000D, 1989, 10, 11);
        staff[2] = new Employee("Tony Tester", 40000D, 1990, 3, 15);
        final String fileName = "employee.dat";
        try (RandomAccessFile out = new RandomAccessFile(fileName, "rw")) {
            for (Employee e : staff) {
                out.writeInt(staff.length);
                writeData(out, e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeData(RandomAccessFile out, Employee e) throws IOException {
        out.writeUTF(e.getName() + "|" + e.getSalary() + "|" + e.getHireDate() + "\n");
    }


    public static class Employee {
        private String name;
        private Double salary;
        private LocalDate hireDate;
        private int year;
        private int month;
        private int day;


        public Employee(String name, Double salary, int year, int month, int day) {
            this.name = name;
            this.salary = salary;
            this.year = year;
            this.month = month;
            this.day = day;
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

        public LocalDate getHireDate() {
            return LocalDate.of(year, month, day);
        }

        public void setHireDate(LocalDate hireDate) {
            this.hireDate = hireDate;
        }
    }
}


