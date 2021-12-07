package com.array;

/*
一。数组的概述

  1.是多个相同类型数据按照一定顺序排列的集合，并使用同一个名字命名，并通过编号的方式对数据进行统一的管理
  2.数组相关的概念：
    >数组名
    >元素
    >角标，下标，索引
    >数组的长度

  3.数组的特点：
     1）数组是有序数列
     2)数组属于引用数据类型。数组的元素可以是基本数据类型也可以是引用类型
     3）创建数组对象会在内存中开辟出一整块连续的空间
     4）数组的长度一旦确定就不能更改

  4。数组的分类
      ①按照维数：一维数组，二维数组
      ②按照数组元素的类型：基本数据类型元素的数组，引用类型数据元素的数组


  5。一维数组的使用
      1)一维数组的声明和初始化
      2）如何调用数组指定位置的元素
      3）如何获取数组的长度
      4）如何遍历数组
      5）数组元素的默认初始化值   见ArrayDemo1.java
      6）数组的内存解析          见ArrayDemo1.java
 */

public class ArrayDemo {

    public static void main(String[] args){

        //1.一维数组的声明和初始化
        int num;//声明
        num = 10;//初始化
        int num1 = 100;//声明+初始化

        String[] name;//声明
        //1.1 静态初始化：数组的初始化和数组的元素赋值同时进行
        name = new String[]{"张三","李四"}; //初始化

        //1.2 动态初始化：数组的初始化和数组的元素赋值分开进行
        String[] names = new String[5];

        String[] birthday = new String[]{"1999,12,0","1998,01,01"}; //数组的 声明+初始化

        //总结：数组一旦初始化完成其长度就确定了
        //2.如何调用数组的指定位置的元素:用过数组的角标方式调用
        //  数组的角标或（索引）从0开始，到数组的长度-1结束

        int[] nuns = {1,3,4,2,6};

        System.out.println(name[1]);
        System.out.println(name[0]);
        System.out.println(birthday[0]);
        System.out.println(birthday[1]);
        System.out.println(nuns[0]);
        System.out.println(nuns[2]);
        System.out.println(nuns[3]);

        //int  s1 = charAt(0);
        //System.out.println(s1);

        //3。如何获取数组的长度
        //   属性：length

/*        System.out.println(nuns.length); // 5
        System.out.println(name.length); // 2
        System.out.println(names.length);// 5
        System.out.println(birthday.length); // 2 */

        for (int i = 0;i < nuns.length;i++){
            System.out.println(nuns[i]);
        }




    }



}
