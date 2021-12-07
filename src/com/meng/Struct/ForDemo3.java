package com.meng.Struct;

public class ForDemo3 {
    public static void main(String[] args) {

        //使用for循环遍历九九乘法表
        //1.打印第一列
        //2.把固定的1在用一个for循环包起来
        //3。去除重复项 （j <= i）
        //4.调整格式

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+"*"+i+"="+(j*i)+"\t");
            }
            System.out.println();
        }

    }
}
