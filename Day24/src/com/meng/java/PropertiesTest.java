package com.meng.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

    //Properties：常用来处理陪着文件，key和value都是String类型
    public static void main(String[] args)  {
        FileInputStream fis = null;
        try {
            Properties pro = new Properties();

            fis = new FileInputStream("JDBC.properties");
            pro.load(fis); //加载对应的流文件
            String name = pro.getProperty("name");
            String password = pro.getProperty("password");

            System.out.println("name = "+name+", password = "+password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }



    }
}
