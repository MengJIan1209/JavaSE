package com.meng.java;

import java.util.ArrayList;
import java.util.List;

public class Order <T>{

    private  String name;
    private  int age;

    //类的内部结构就可以使用类的泛型
    T orderT;

    public Order(){

        //编译不通过
//        T[] arr = new T[10];

        //编译通过
        T[] arr = (T[]) new Object[10];

    }

    public Order(String name,int age,T orderT){
        this.name = name;
        this.age = age;
        this.orderT = orderT;
    }

    public T getOrderT(){
        return orderT;

    }

    public void  setOrderT(T orderT){
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", orderT=" + orderT +
                '}';
    }

    //静态方法中不能使用类的泛型
//    public static void show(T orderT){
//        System.out.println(orderT);
//    }

    public void show(){
        //编译不通过
//        try {
//
//        }catch (T t){
//
//        }

    }

    //  泛型方法 ：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有关系
    //  换句话说，泛型方法所属的类是不是泛型类都没有关系
    //  泛型方法，可以声明为静态的。原因，泛型参数是在调用方法时确定的，并非在实例化类时没确定。
    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();

        for (E e:arr){
            list.add(e);
        }
        return list;
    }
}
