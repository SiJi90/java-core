package com.example.io.tcp.demo1;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/28
 */
public class TestCount {

    public static void main(String[] args) throws Exception {

        URL resource = TestCount.class.getClassLoader().getResource("word.txt");
        String contents = new String(Files.readAllBytes(Paths.get(resource.toURI())), StandardCharsets.UTF_8);

        List<String> words = Arrays.asList(contents.split("\\PL+"));

        //Stream<String> words = Stream.of(contents.split("\\PL+"));
        long count = 0;

       /* for (String word : words) {
            System.out.println("word = " + word);
            if (word.length() > 12) {
                count++;
            }
        }*/
        // 替换为流操作
        words.stream().filter(w -> w.length() > 12).forEach(System.out::println);
        // 使用并行流的方式
        count = words.parallelStream().filter(w -> w.length() > 12).count();

        System.out.println("count = " + count);
    }
}
