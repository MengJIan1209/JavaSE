package com.array;
/*
  二维数组的使用：
        声明：int[][] arr = new int[4][5];
        外层元素：arr[0],arr[1]....
        内层元素：arr[0][1],arr[1][1]....
   1.数组元素的默认初始化值
        针对于初始化方式一：比如 int[][] arr = new int[3][2];
             外层元素初始化值：地址值
             内层元素初始化值：与一维数组情况相同

         针对于初始化方式二：比如 int[][] arr1 = new int[3][];
             外层元素初始化值：null
             内层元素初始化值：不能调用，否则报错（空指针异常）


   2.数组的内存解析



 */
public class ArrayDemo5 {

    public static void main(String[] args){

        int[][] arr = new int[4][5];
        System.out.println(arr[0]);  //[I@1b6d3586 地址值
        System.out.println("----------------");
        System.out.println(arr[0][0]);

        System.out.println("----------------");
        int[] arr1 =new int[5];
        System.out.println(arr1); //[I@4554617c 地址值


        System.out.println("********************\n");
        String[] name[] = new String[3][5];
        System.out.println(name[0]);  //@74a14482 地址值
        System.out.println(name[1][1]); // null


        System.out.println("********************\n");
        float[] num[] = new float[3][6];
        System.out.println(num[0]);  //[F@1540e19d 地址值
        System.out.println(num[1][2]); // 0.0


        System.out.println("********************\n");
        char[] nuns[] = new char[3][2];
        System.out.println(nuns[0]);
        System.out.println(nuns[1][1]);




    }

}
