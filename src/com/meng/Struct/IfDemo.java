package com.meng.Struct;

import java.util.Scanner;

public class IfDemo {
    public static void main(String[] args) {
        //考试成绩大于60分及格 小于60不及格

        Scanner scanner = new Scanner(System.in);

        System.out.printf("请输入你的成绩：");
        int score = scanner.nextInt();

        if(score>=60){
            System.out.printf("成绩及格！");
        }else{
            System.out.printf("成绩不及格！");

        }

        scanner.close();


    }
}
