package com.meng.java;
/*
        自定义泛型类：

        1.

 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest1 {

    @Test
    public void test1(){
        //如果定义了泛型，实例化没有指明类的泛型，则默认此泛型类型为Object类型
        //要求：如果定义了类是带泛型的，建议在实例化时要指明类的泛型
        Order order1 = new Order();

        //建议：实例化时指明泛型
        Order<String> order = new Order<String>("orderAA",12,"order:AA");

        order.setOrderT("AA:Hello");
    }

    @Test
    public void test2(){
        SubOrder sub1 = new SubOrder();

        //由于子类在继承带泛型的父类时，指明了泛型的类型。则实例化子类对象时，不在需要指明泛型
        sub1.setOrderT(123);

        SubOrder1<String> subOrder1 = new SubOrder1<>();

        subOrder1.setOrderT("order...");
    }

    @Test
    public void test3(){
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        //泛型不同的引用不能相互赋值
//        list1 = list2;


    }

    @Test
    public void test4(){
        Order<String> order = new Order<>();

        Integer[] arr = new Integer[]{1,2,3,4};

        List<Integer> list = order.copyFromArrayToList(arr);

        System.out.println(list);


    }


}
