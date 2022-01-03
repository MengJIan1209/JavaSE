package com.meng.java;

import org.junit.Test;

import java.io.*;
/*
    其他流的使用：
    1.标准的输入，输出流
    2.打印流
    3.数据流

 */

public class OtherStreamTest {
    /*
         1.标准的输入输出流
         1.1
         System.in： 标准的输入流，默认从键盘输入
         System.out：标准的输出流，默认从控制台输出
         1.2
         System类的setIN(InputStream is) / (PrintStream ps) 方式重新指定输入和输出的流

         1.3
         从键盘输入字符串，要求将读取到的整行字符串转成大写输出，然后继续进行输入操作
         直至当输入“e” 或 “exit”时，退出程序

         方法一：使用Scanner实现 调用next()返回一个字符串
         方法二：使用System.in实现。 System.in ---> 转换流 ---> BufferedReader的readLine()
     */

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            while (true){
                System.out.println("请输入字符串：");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束！");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        2. 打印流 ：PrintStream 和 PrintWriter

        2.1  提供了一系列重载的print() 和 println()方法
        2.2  练习
     */
    @Test
    public void test1(){
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("D:\\IO\\text.txt"));
            // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
            if (ps != null) {// 把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }
            for (int i = 0; i <= 255; i++) { // 输出ASCII字符
                System.out.print((char) i);
                if (i % 50 == 0) { // 每50个数据一行
                    System.out.println(); // 换行
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }

    }

    /*
        3. 数据流
        3.1 DataInputStream 和 DataOutputStream
     */
    @Test
    public void test2(){
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("data.txt"));

            dos.writeUTF("王五");
            dos.flush();
            dos.writeInt(22);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        将文件存储的基本数据类型变量和字符串读取到内存中，保存在变量中

        注意点：读取不同类型的数据的顺序要和当初写入文件时，保存到数据顺序一致

     */
    @Test
    public void test3(){
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("data.txt"));

            String name = dis.readUTF();
            int age = dis.readInt();
            boolean isMale = dis.readBoolean();

            System.out.println("姓名："+ name);
            System.out.println("年龄："+ age);
            System.out.println("isMale："+ isMale);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dis != null){
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }
}
