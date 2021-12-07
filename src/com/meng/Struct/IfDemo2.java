package com.meng.Struct;

import java.util.Scanner;

public class IfDemo2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.printf("请输入你的分数:");
        int score = scanner.nextInt();

        if (score==60){
            System.out.printf("及格！");
        }else if (score>=70&&score<80){
            System.out.printf("良好！");
        }else if (score>=80&&score<90){
            System.out.printf("优秀！");
        }else if (score>=90&&score<=100){
            System.out.printf("你真是个天才！");
        }else{
            System.out.printf("不及格！");
        }

        scanner.close();
    }
}

