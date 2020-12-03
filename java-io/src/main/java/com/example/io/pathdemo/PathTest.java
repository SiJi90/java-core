package com.example.io.pathdemo;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/29
 */
public class PathTest {
    public static void main(String[] args) throws IOException {
        Path absolute = Paths.get("/home", "harry");
        Path relative = Paths.get("myprog", "conf", "user.properties");
        System.out.println("relative = " + relative);
        File file = relative.toFile();
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        System.out.println(file.exists());
    }

    @Test
    public void test2() {
        String baseDir = System.getProperty("user.dir");

        Path basePath = Paths.get(baseDir);
        Path work = Paths.get("/work");
        Path workPath = basePath.resolve(work);
        System.out.println("workPath = " + workPath);

    }
}
