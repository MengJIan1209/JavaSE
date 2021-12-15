package com.meng.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 *  JDK 5.0新增了foreach循环，用于遍历集合，数组
 */
public class ForTest {


    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //for(集合元素的类型  局部变量 ： 集合对象)
        //内部仍然使用了迭代器
        for(Object obj : coll){
            System.out.println(obj);
        }

    }

    @Test
    public void test2(){

        int[] arr = new int[]{1,2,3,4,5};

        //for(数组元素的类型  局部变量 ： 数组对象)
        for (int i : arr){
            System.out.println(i);
        }

    }

    @Test
    public void test3(){

        String[]   str = new String[]{"AA","AA","AA"};

//        //方式一：普通for循环
//        for (int i = 0; i < str.length; i++) {
//            str[i] = "DD";
//        }

        //方式二：增强型for循环
        for (String s : str){
            s = "DD";
        }


        for (int i  = 0; i < str.length ; i++){
            System.out.println(str[i]);
        }



    }

}
