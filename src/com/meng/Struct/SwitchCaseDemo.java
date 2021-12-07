package com.meng.Struct;

import java.util.Scanner;

//case 穿透
//switch 匹配一个具体的值

public class SwitchCaseDemo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.printf("请输入你的等级(A-E)");
        String grade = scanner.nextLine();

        switch(grade){
            case "A":
                System.out.printf("优秀！");
                break;
            case "B":
                System.out.printf("良好！");
                break;
            case "C":
                System.out.printf("及格！");
                break;
            case "D":
                System.out.printf("再接再厉！");
                break;
            case "E":
                System.out.printf("挂科！");
                break;
            default:
                System.out.printf("未知等级");
        }
            scanner.close();
    }
}
