package com.meng.java;
/*
      处理流之一： 缓冲流

      1.缓冲流
      BufferedInputStream
      BufferedOutputStream
      BufferedReader
      BufferedWriter

 */

import org.junit.Test;

import java.io.*;

public class BufferedTest {
    /*
          处理非文本文件的复制
     */

    @Test
    public void BufferedStreamTest(){
//        FileInputStream fis = null;
//        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.实例化File类的对象
            File srcFile = new File("蓝色泪海.jpg");
            File destFile = new File("蓝色泪海2.jpg");

            //2.实例化流的对象
            //2.1 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节： 读取，写入
            byte[] buffer = new byte[5];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
            System.out.println("复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            //要求：先关闭外层的流，再关闭内层的流
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略。
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != bos){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//            if (fis != null){
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (fos != null){
//                try {
//                    fos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }

    //实现文件复制的方法

    public void copyFileWithBuffered(String srcPath,String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.实例化File类的对象
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //2.实例化流的对象
            //2.1 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节： 读取，写入
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
            System.out.println("复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            //要求：先关闭外层的流，再关闭内层的流
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略。
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != bos) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //测试copyFileWithBuffered()方法
    @Test
    public void testCopyFileWithBuffered(){

        long start = System.currentTimeMillis();

        String srcPath ="D:\\Desktop\\尚硅谷-03-常见的DBMS的对比.mp4";
        String destPath = "D:\\Desktop\\尚硅谷-03-常见的DBMS的对比11.mp4";

        copyFileWithBuffered(srcPath,destPath);

        long end = System.currentTimeMillis();

        System.out.println("复制花费的时间为："+(end - start)); // 177

    }

}
