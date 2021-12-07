package scanner;

import java.util.Scanner;

public class Demo3 {

    public static void main(String[] args) {

        int i = 0;
        float f= 0.0f;

        Scanner scanner = new Scanner(System.in);

        System.out.println("输入整数：");

        if (scanner.hasNextInt()){
            i = scanner.nextInt();
            System.out.println("整数数据："+i);
        }else{
            System.out.println("不是整数数据！");
        }

        System.out.println("输入小数数据：");

        if (scanner.hasNextFloat()){
            f = scanner.nextFloat();
            System.out.println("小数数据："+f);
        }else{
            System.out.println("不是小数数据！");
        }



    }


}
