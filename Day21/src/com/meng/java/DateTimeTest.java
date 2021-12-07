package com.meng.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * jdk 8.0之前的日期事件API测试
 * 1.System类中的currentTimeMillis()
 * 2.java.util.Date和子类java.sql.date
 * 3.SimpleDateFormat
 * 4.Calendar
 */
public class DateTimeTest {

    /*
     * SimpleDateFormat()的使用 ：SimpleDateFormat是对Date日期的格式化和解析
        1.两个操作
        * 1.1 格式化：日期 ---> 字符串
        * 1.2 解析 ：格式化的逆操作 字符串 ---> 日期
        2.SimpleDateFormat的实例化
     */
    @Test
    public void test1() throws ParseException {
        //实例化SimpleDateFormat :使用默认的构造器
        SimpleDateFormat mat = new SimpleDateFormat();

        //格式化： 日期 ---> 字符串
        Date date = new Date();
        System.out.println(date);

        String format = mat.format(date);
        System.out.println(format);

        //解析：  字符串 ---> 日期
        String str = "21-12-7 下午8:25";
        Date date1 = mat.parse(str);
        System.out.println(date1);

        System.out.println("******按照指定的方式格式化和解析：调用带参的构造器****************");

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format2 = format1.format(date);
        System.out.println(format2);

        //解析:要求字符串必须是复合SimpleDateFormat识别的格式(通过构造器体现)否则抛异常
        Date date2 = format1.parse("2021-12-07 08:37:33");
        System.out.println(date2);

    }

    /*
     *  练习一：字符串：“2021-12-16”转化为java.sql.Date

     */


    @Test
    public void test2() throws ParseException {
        
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

        String birth = "2021-12-16";
//        java.sql.Date date = new java.sql.Date(birth);
//        System.out.println(date);
        Date parse = sdf1.parse(birth);
        System.out.println(parse);

        java.sql.Date birthDate = new java.sql.Date(parse.getTime());
        System.out.println(birthDate);

    }

}
