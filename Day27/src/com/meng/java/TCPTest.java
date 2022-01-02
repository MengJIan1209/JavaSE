package com.meng.java;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest {

    @Test
    public void client() {

        Socket socket = null;
        OutputStream socketOutputStream = null;
        try {
            //1.创建Socket对象，指明服务器端的ip和端口号
            InetAddress inet = InetAddress.getByName("localhost");
            socket = new Socket(inet,8899);

            //2.获取一个输出流，用于输出数据
            socketOutputStream = socket.getOutputStream();
            //3.写出数据的操作
            socketOutputStream.write("正在学习TCP网络编程".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (socketOutputStream != null){
                try {
                    socketOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }



    }

    @Test
    public void Server()  {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream socketInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            //1.创建服务器端的ServerSocket对象，知名自己的端口号
            serverSocket = new ServerSocket(8899);

            //2.调用accept()方法，表示接收来自客户端的socket
            socket = serverSocket.accept();

            //3.获取输入流
            socketInputStream = socket.getInputStream();

            //不建议这样写，可能会有乱码
//        byte[] buffer = new byte[20];
//        int len;
//        while ((len = socketInputStream.read(buffer))!= -1){
//            String str = new String(buffer,0,len);
//            System.out.println(str);
//        }

            //读取输入流中的数据
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[]  buffer = new byte[20];
            int len;
            while ((len = socketInputStream.read(buffer)) != -1){
                byteArrayOutputStream.write(buffer,0,len);
            }
            System.out.println(byteArrayOutputStream.toString());

            System.out.println("收到了来自："+socket.getInetAddress().getHostAddress()+"的数据！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (byteArrayOutputStream != null){
                try {
                     //关闭资源
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(socketInputStream != null){
                try {
                    socketInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }









    }

}
