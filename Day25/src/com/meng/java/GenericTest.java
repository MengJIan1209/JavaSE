package com.meng.java;

import org.junit.Test;

import java.util.*;

/*
        泛型的使用：
           1.JDK 5.0新增的特性

           2.在集合中使用泛型 :
            总结：
             ①：集合接口或集合类在JDK5.0 时，都修改为带泛型的结构
             ②：在实例化集合类时，可以指明具体的泛型类型
             ③：指明完以后，在集合类或接口中凡是定义类或者接口时，内部结构(比如：方法，构造器，属性)使用到泛型的位置，都指定为实例化的泛型类型。
                 比如：add(E,e) ----> 实例化以后：add(Integer,e)
             ④：注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换
             ⑤：如果实例化时，没有指明泛型的类型，默认类型为java.lang.Object类型

           3.如何自定义泛型结构：泛型类，泛型接口；泛型方法   --->见 GenericTest1.java
 */
public class GenericTest {

     @Test
    public void test1(){
         ArrayList list = new ArrayList();
         //需求：存放学生的成绩
         list.add(44);
         list.add(56);
         list.add(13);
         list.add(88);
         list.add(99);
         //:问题一：类型不安全
//         list.add("Tom");

         for (Object score : list){
             //问题二：强转时，可能出现ClassCastException
             int stuScore = (Integer) score;

             System.out.println(stuScore);
         }


     }

     //在集合中使用泛型的情况 :以ArrayList为例
    @Test
    public void test2(){

         ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(44);
        list.add(56);
        list.add(13);
        list.add(88);
        list.add(99);
        //编译时，就会进行类型检查，保证数据安全
//        list.add("Tom");

        //方式一：增强for循环
//        for (Integer score : list){
//            //避免了强转操作
//            int stuScore = score;
//
//            System.out.println(stuScore);
//        }

        //方式二：迭代器
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()){
            int stuScore = iterator.next();

            System.out.println(stuScore);
        }

    }

    //在集合中使用泛型的情况 :以HashMap为例
    @Test
    public void test3(){
//         Map<String,Integer> map = new HashMap<String,Integer>();
         //jdk 7新特性：类型推断
         Map<String,Integer> map = new HashMap<>();

         map.put("Tom",66);
         map.put("Jack",61);
         map.put("Mike",88);
         map.put("Jerry",99);

//         map.put(123,"Jsd");

        //泛型的嵌套
        Set<Map.Entry<String,Integer>> entry =  map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();

            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key+"----"+value);
        }

    }



}
