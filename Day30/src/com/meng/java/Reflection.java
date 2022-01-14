package com.meng.java;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflection {

    public static void main(String[] args) throws Exception {
        //1.写出获取Class实例的三种方式
        Class<User> clazz = User.class;
        System.out.println(clazz);

        Class clazz1 = Class.forName("com.meng.java.User");
        System.out.println(clazz1);

        User user1 = new User();
        Class clazz2 = user1.getClass();
        System.out.println(clazz2);


        //2.创建Class对应运行时类的对象的通用方法
        User user = clazz.newInstance();
        System.out.println(user);

        //3.如何调用方法show()
        Method show = clazz.getDeclaredMethod("show");
        show.setAccessible(true);
        show.invoke(user);

        //4.使用ClassLoader()加载配置文件
        Properties pro = new Properties();
        ClassLoader classLoader = Reflection.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("JDBC.properties");
        pro.load(is);

        String name = pro.getProperty("name");
        System.out.println("name : " + name);


    }


}
