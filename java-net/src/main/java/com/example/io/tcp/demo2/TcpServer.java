package com.example.io.tcp.demo2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/25
 */
public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);

        while (true) {
            Socket accept = serverSocket.accept();
            InputStream is = accept.getInputStream();
            OutputStream os = accept.getOutputStream();

            byte[] bytes = new byte[1024];

            File file = new File("d:\\upload");
            if (!file.exists()) {
                file.mkdirs();
            }

            String name = System.currentTimeMillis() + new Random().nextInt(999999) + "头像.png";

            FileOutputStream fos = new FileOutputStream(file + File.separator + name);
            int len = 0;

            while ((len = is.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }

            os.write("上传成功".getBytes());

            accept.close();

        }

    }
}
