package com.meng.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ClassLoaderTest {

    /*
    Properties: 用来读取配置文件
     */
    @Test
    public void test1() throws IOException {
        Properties pro = new Properties();
        //此时的文件默认在当前的module下
        //读取配置文件的方式一：
//        FileInputStream fis = new FileInputStream("JDBC.properties");
        FileInputStream fis1 = new FileInputStream("src\\JDBC1.properties");
//        pro.load(fis);
        pro.load(fis1);

        //读取配置文件的方式二：使用ClassLoader
        //配置文件默认识别为：当前module的src下
//        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
//        InputStream is = classLoader.getResourceAsStream("JDBC1.properties");
//        pro.load(is);


        String user = pro.getProperty("user");
        String password = pro.getProperty("password");

        System.out.println("user = "+ user + " , password = " + password);

    }

}
