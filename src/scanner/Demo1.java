package scanner;

import java.util.Scanner;

public class Demo1 {

    public static void main(String[] args) {
        //创建一个扫描器对象
        Scanner scanner = new Scanner(System.in);

        System.out.println("使用next方式来接收");
        //判断用户有没有输入字符串
        if (scanner.hasNext()) {
            //使用next接收
            String str = scanner.next();
            System.out.println("接收的字符为：" + str);
        }
        //凡是属于IO流的类如果不关闭会一直占用资源
        scanner.close();

    }
}