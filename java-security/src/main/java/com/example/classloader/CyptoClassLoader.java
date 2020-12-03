package com.example.classloader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author: slm
 */
public class CyptoClassLoader extends ClassLoader {

    private int key;

    public CyptoClassLoader(int key) {
        this.key = key;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] classBytes;
            classBytes = loadClassBytes(name);
            Class<?> aClass = defineClass(name, classBytes, 0, classBytes.length);
            if (aClass == null) {
                throw new ClassNotFoundException(name);
            }
            return aClass;
        } catch (Exception e) {
            throw new ClassNotFoundException(name);
        }
    }

    private byte[] loadClassBytes(String name) throws IOException {
        String cname = name.replace('.', '/') + ".caesar";
        byte[] bytes = Files.readAllBytes(Paths.get(cname));
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] - key);
        }
        return bytes;
    }
}
