package com.meng.java;

import org.junit.Test;

import java.io.*;

/*
    测试FileInputStream 和 FileOutputStream的使用

    结论：
    1.对于文本文件(.txt,.java,.c,.cpp),使用字符流处理
    2.对于非文本文件(.jpg,.ppt,.doc,.mp3,.mp4,.avi) 使用字节流处理

 */
public class FileInputOutputStreamTest {

    @Test
    //使用字节流FileInputStream处理文本文件，可能会出现乱码
    public void testFileInputStream() {
        FileInputStream fis = null;
        try {
            //1.File类的实例化
            File file = new File("hello.txt");

            //2.FileInputStream流的实例化
            fis = new FileInputStream(file);

            //3.读取数据
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1){
                String str = new String(buffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
          实现对图片的复制操作
     */
    @Test
    public void testFileInputOutputStreamTest() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("蓝色泪海.jpg");
            File destFile = new File("蓝色泪海1.jpg");

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
            System.out.println("复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流资源的关闭
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void copyFile(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
            System.out.println("复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流资源的关闭
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();

        String srcPath = "D:\\Desktop\\尚硅谷-03-常见的DBMS的对比.mp4";
        String destPath = "D:\\Desktop\\尚硅谷-03-常见的DBMS的对比1.mp4";

//        String srcPath = "hello.txt";
//        String destPath = "hello3.txt";
        copyFile(srcPath,destPath);

        long end = System.currentTimeMillis();

        System.out.println("复制花费的时间为："+(end - start)); //648


    }

}
