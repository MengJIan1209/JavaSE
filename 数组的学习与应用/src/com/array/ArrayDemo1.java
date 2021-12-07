package com.array;

/*
5）数组元素的默认初始化值
    >数组元素是整型: 0
    >数组元素是浮点型： 0.0
    >数组元素是char型： 0或者'\u0000' 而非 '0'
    >数组元素是boolean型： false

    >数组元素是引用数据类型： null

6）数组的内存解析   栈 堆

 */


public class ArrayDemo1 {

    public static void main(String[]args){

        //5.数组元素的默认初始化值

        int[] nums = new int[4];
        for (int i = 0;i < nums.length;i++){
            System.out.println(nums[i]);
        }
        System.out.println("---------------");

        short[] n1 = new short[5];
        for (int i = 0;i < n1.length;i++){
            System.out.println(n1[i]);
        }
        System.out.println("---------------");

        float[] n2 = new float[4];
        for (int i = 0;i < n2.length;i++){
            System.out.println(n2[i]);
        }
        System.out.println("---------------");

        char[] n3 = new char[4];
        for (int i = 0;i < n3.length;i++){
            System.out.println(n3[i]);
        }
        if (n3[2] == 0){
            System.out.println("好好学习，天天向上！");
        }
        System.out.println("---------------");

        boolean[] n4 = new boolean[5];
        for (int i = 0;i < n4.length;i++){
            System.out.println(n4[i]);
        }
        System.out.println("---------------");

        String[] s1 = new String[4];
        for (int i = 0;i < s1.length;i++){
            System.out.println(s1[i]);
        }
        if(s1[3] == null){
            System.out.println("今天也是努力学习的一天呢！");
        }
        System.out.println("---------------");



    }

}
