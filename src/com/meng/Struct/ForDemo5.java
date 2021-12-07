package com.meng.Struct;
// 一个数如果恰好等于它的因子之和 这个数就称之为”完数“，例如 6=1+2+3；
// 找出1000以内的所有完数（因子：除去这个数本身的其他约数）


public class ForDemo5 {

    public static void main(String[] args){

        for (int i = 1; i < 1000; i++) {
            //定义因子
            int factor = 0;
            for(int j = 1;j <= i/2;j++){
                if( i%j == 0){
                    factor +=j;
                }
            }
            if (i == factor){
                System.out.println(i);
            }

        }





    }
}
