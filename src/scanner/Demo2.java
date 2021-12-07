package scanner;

import java.util.Scanner;

public class Demo2 {

    public static void main(String[] args) {
        //创建扫描器 从键盘接收数据
        Scanner scanner = new Scanner(System.in);
        System.out.println("使用nextLine接收到的数据为：");

        //判断是否有输入
        if (scanner.hasNextLine()) {
            //使用nextLine接收
            String str = scanner.nextLine();
            System.out.println("接收的字符为：" + str);

        }
           scanner.close();
        
    }
}

