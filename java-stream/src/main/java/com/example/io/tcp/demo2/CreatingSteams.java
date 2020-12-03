package com.example.io.tcp.demo2;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @description:
 * @author: slm
 * @create: 2020/10/06
 */
public class CreatingSteams {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("java_stream/alice.txt");
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        Stream<String> words = Stream.of(contents.split("\\r\\n"));
        show("words", words);

        Stream<String> song = Stream.of("gently", "down", "the", "stream");
        show("song", song);

        Stream<Object> silence = Stream.empty();
        show("silence", silence);

        Stream<Double> randoms = Stream.generate(Math::random);
        show("randoms", randoms);

        Stream<String> echos = Stream.generate(() -> "echo");
        show("echos", echos);

        Stream<BigInteger> integers = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE));
        show("integers", integers);

        Stream<String> wordAnotherWay = Pattern.compile("\\r\\n").splitAsStream(contents);
        show("wordAnotherWay", wordAnotherWay);

        Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
        show("lines", lines);

        Iterable<Path> iterable = FileSystems.getDefault().getRootDirectories();
        Stream<Path> rootDirectory = StreamSupport.stream(iterable.spliterator(), false);
        show("rootDirectory", rootDirectory);

        Stream.of(contents.split("\\r\\n")).peek(e -> System.out.println("this is " + e)).forEach(System.out::println);


    }

    public static <T> void show(String title, Stream<T> stream) {
        final int SIZE = 13;
        List<T> firstElements = stream.limit(SIZE + 1).collect(Collectors.toList());
        System.out.print(title + ":");
        for (int i = 0; i < firstElements.size(); i++) {
            if (i > 0) {
                System.out.print(",");
            }
            if (i < SIZE) {
                System.out.print(firstElements.get(i));
            } else {
                System.out.print("...");
            }
        }
        System.out.println();
    }


}
