package com.example.io;

import java.util.Map;
import java.util.Properties;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/28
 */
public class LineSeparator {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        for (Map.Entry<Object, Object> objectEntry : properties.entrySet()) {
            System.out.println(objectEntry.getKey() + "-------" + objectEntry.getValue());
        }
    }
}
