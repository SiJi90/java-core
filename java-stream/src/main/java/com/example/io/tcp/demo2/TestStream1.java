package com.example.io.tcp.demo2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/06
 */
public class TestStream1 {
    public static Logger log = Logger.getGlobal();

    public static void main(String[] args) throws IOException {
        byte[] datas = Files.readAllBytes(Paths.get("java_stream\\alice.txt"));
        String data = new String(datas, StandardCharsets.UTF_8);
        String[] words = data.split("\\r\\n");
        List<String> strings = Arrays.asList(words);
        long count2 = strings.parallelStream().filter(w -> w.length() > 3).count();
        System.out.println("count2 = " + count2);
        int count = 0;
        for (String word : words) {
            if (word.length() > 3) {
                count++;
            }
        }
        System.out.println("count = " + count);
        long count1 = Arrays.stream(words).filter(e -> e.length() > 3).count();
        System.out.println("count1 = " + count1);
    }
}
