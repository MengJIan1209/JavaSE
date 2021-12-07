package com.meng.Struct;

public class ForDemo4 {

    public static void main(String[] args){

        int[] numbers = {1,2,3,4,5};  //定义一个名字为numbers的数组

        for (int i = 0; i < 5; i++) {
            System.out.println(numbers[i]);
        }
        System.out.println("=====================");

        for(int x:numbers){
            System.out.println(x);
        }
    }

}
