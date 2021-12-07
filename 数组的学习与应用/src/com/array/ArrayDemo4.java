package com.array;

/*
   二维数组的使用：
   1.理解
   对于二维数组的理解，我们可以看成是一维数组array1又作为另一个一维数组array2的元素而存在
   其实，从数组底层的运行机制来看，并没有多维数组

   2.
    1。二维数组的声明和初始化
    2。如何调用数组指定位置的元素
    3。如何获取数组的长度
    4。如何遍历数组
    5。数组元素的默认初始化值
    6。数组的内存解析





 */

public class ArrayDemo4 {

    public static void main(String[] args){

        //1。二维数组的声明和初始化
        //String[] array = new String[]{}; //一维数组静态初始化
        String[] array = new String[4];  //一维数组动态初始化


        //int[][] array1 = new int[][]{{1,2,3},{3,4,5},{5,2,7}}; //二维数组静态初始化
        //二维数组动态初始化 1
        int[][] array1 = new int[4][6];
        //二维数组动态初始化 2
        int[][] array2 = new int[4][];

        String[] name[] = new String[4][6];

        //错误情况
//        int[][] array3 = new int[][4];

        //正确的情况
        int[] array4[] = new int[][]{{1,3,4},{1,3,5}};
        int[] array5[] = {{1,3,4},{1,3,5},{4,7}};


        //2.如何调用数组指定位置的元素
        System.out.println(array4[1][2]); // 5
        System.out.println(array5[2][1]); // 7
        System.out.println(array1[1][3]); //整型 默认值为 0

        System.out.println(name[1][1]);   //null
        System.out.println("**********************");


        //3.获取数组长度
        System.out.println(array4.length);
        System.out.println(array4[0].length);
        System.out.println(array4[1].length);
        System.out.println("**********************");


        //4.如何遍历二维数组  二维数组遍历用嵌套for循环
        for (int i = 0;i < array4.length;i++){
            for (int j = 0;j<array4[i].length;j++){
                System.out.print(array4[i][j]+"  ");
            }
            System.out.println();
        }



    }

}
