package com.example.io.tcp.demo2;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @description: 文件上传案例
 * @author: slm
 * @create: 2020/08/25
 */
public class TcpClient {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(TcpClient.class.getClassLoader().getResource("1.png").getPath());

        Socket socket = new Socket("127.0.0.1", 8000);

        OutputStream os = socket.getOutputStream();


        byte[] bytes = new byte[1024];

        int len = 0;

        while ((len = fis.read(bytes)) != -1) {
            os.write(bytes, 0, len);
        }

        socket.shutdownOutput();

        InputStream is = socket.getInputStream();

        while ((len = is.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }

    }
}
