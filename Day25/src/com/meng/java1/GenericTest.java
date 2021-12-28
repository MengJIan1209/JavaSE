package com.meng.java1;
/*
        1.泛型在继承方面的体现：


        2.通配符的使用

 */

import org.junit.Test;

import java.util.ArrayList;

public class GenericTest {
    /*
    1.泛型在继承方面的体现：

        类A是类B的父类，G<A> 和 G<B> 二者不具备子父类关系，二者是并列关系

     */

    @Test
    public void test1(){

        Object obj = null;
        String str = null;

        obj = str;

        Object[] arr = null;
        String[] str1 = null;

        arr = str1;


         //编译不通过
//        Date date = new Date();
//        str = date;

        ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        //此时的list1和list2不具有字符类关系
        //编译不通过
//        list1 = list2;



    }



}
