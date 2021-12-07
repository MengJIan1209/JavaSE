package com.meng.java;


import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 *  涉及到String类与其他结构之间的转化
 */
public class StringTest1 {

    /*
     *      String 与 byte[]之间的转换
     *
     *     编码： String --->byte[] :调用String的getBytes()方法
     *     解码： byte[] --->String :String
     *
     *      编码：字符串 -->字节(由可见性语言--->二进制语言)
     *      解码：字节   -->字符串(二进制语言 ---->可见性语言)
     *
     */

    @Test
    public void test3() throws UnsupportedEncodingException {
        String str = "abc123中国";
        byte[] bytes = str.getBytes();// 使用默认的字符集，进行编码
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str.getBytes("GBK"); //使用gbk字符集进行编码
        System.out.println(Arrays.toString(gbks));

        System.out.println("*****************");

        String str2 = new String(bytes); //使用默认字符集进行解码
        System.out.println(str2);

        String str3 = new String(gbks);
        System.out.println(str3);//出现乱码：原因是编码集和解码集不一致

        String str4 = new String(gbks, "gbk");
        System.out.println(str4);

    }


    /*
     * String 与 char[]之间的转换

       String --->char[] : 调用String的toCharArray()方法
       char[] --->String : 调用String构造器
     */

    @Test
    public void test2(){

        String str = "abc123";
        char[] toCharArray = str.toCharArray();
        for (int i = 0; i < toCharArray.length; i++) {
            System.out.println(toCharArray[i]);
        }

        char[] arr = new char[]{'h','e','l','l','o'};
        String s1 = new String(arr);
        System.out.println(s1);


    }

    /*
     *复习：
     * String 与基本数据类型和包装类之间的转化
     * String --->基本数据类型，包装类:调用包装类的静态方法 parseXxx(str)
     * 基本数据类型，包装类 --->String ：调用String重载的valueOf(xxx)方法

     */

    @Test
    public void test1(){
        String s1 = "123";
        int num = Integer.parseInt(s1);
        System.out.println(num);

        String s2 = String.valueOf(num); //"123"
        String s3 = ""+num;


    }

}
