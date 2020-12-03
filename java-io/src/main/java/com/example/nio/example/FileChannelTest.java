package com.example.nio.example;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: slm
 */
public class FileChannelTest {

    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("1.txt", "rw");
        FileChannel channel = file.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        while (channel.read(buf) != -1) {
            System.out.println("buf = " + buf);
        }
        buf.flip();
        while (buf.hasRemaining()) {
            System.out.print((char) buf.get());
        }

        file.close();
    }
}
