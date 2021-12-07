package com.meng.java;

import org.junit.Test;

/**
 *  JDK8.0 之前时间和日期的API测试
 */
public class DateTimeTest {

    /*
        String类中的currentTimeMillis()
     */
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        //称为时间戳
        System.out.println(time);
    }

}
