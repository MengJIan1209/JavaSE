package com.meng.Struct;

public class TestDemo {

        /*
        for的利用
        */

        public static void main(String[] args){


            //打印杨辉三角
            for (int i = 1; i <=5; i++) {
                for (int j =5 ;j>=i;j--){
                    System.out.print(" ");
                }
                for(int j = 1;j<=i;j++){
                    System.out.print("*");
                }
                for(int j = 1;j<i;j++){
                    System.out.print("*");
                }
                System.out.println();
            }

        }

}
