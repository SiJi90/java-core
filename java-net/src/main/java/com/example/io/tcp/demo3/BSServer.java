package com.example.io.tcp.demo3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: slm
 * @create: 2020/08/26
 */
public class BSServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);

        System.out.println("服务器启动。。。");

        Socket socket = serverSocket.accept();

        System.out.println("连接进入");
        System.out.println(socket.getRemoteSocketAddress());

        InputStream is = socket.getInputStream();

     /*   byte[] bytes = new byte[1024];

        int len = 0;

        while ((len = is.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }*/

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        String line = bufferedReader.readLine();
        String[] strings = line.split(" ");
        String htmlPath = strings[1].substring(1);

        FileInputStream fis = new FileInputStream(htmlPath);

        OutputStream os = socket.getOutputStream();

        os.write("http/1.1 200 ok".getBytes());
        os.write("Content-Type:text/html\r\n".getBytes());
        os.write("\r\n".getBytes());

        byte[] bytes = new byte[1024];
        int len = 0;

        while ((len = fis.read(bytes)) != -1) {
            os.write(bytes, 0, len);
        }

        fis.close();
        socket.close();
        serverSocket.close();


    }
}
