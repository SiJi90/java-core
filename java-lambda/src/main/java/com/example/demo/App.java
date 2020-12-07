package com.example.demo;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author: slm
 */
public class App {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        new Thread().start();

        sayHello(App::getName);
        System.out.println("");
        forEach("hello,hi,young", t ->
        {
            String[] split = t.split(",");
            for (String s : split) {
                System.out.println("s = " + s);
            }
        });

    }


    private static String getName() {
        return "李四";
    }

    static <T> void sayHello(Supplier<T> supplier) {
        T t = supplier.get();
        System.out.printf("Hello, %s", t);
    }

    static <T> void forEach(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }
}
