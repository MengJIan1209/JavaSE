package com.meng.Struct;

public class DoWhileDemo2 {

         public static void main(String[] args){
             int i = 0;
             //int sum = 0;
             while(i<0){
                 System.out.println(i);
                 i++;
             }
             //System.out.println(sum);
             System.out.println("===========================");

             do{
                 System.out.println(i);
                 i++;
             }while(i<0);

         }

}
