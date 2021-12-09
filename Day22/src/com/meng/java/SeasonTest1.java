package com.meng.java;

import com.meng.java1.MyAnnotation;

/**
 *  使用enum关键字 定义枚举类
 *
 *  说明：定义的枚举类默认继承于class java.lang.Enum类
 *
 */
public class SeasonTest1 {

    public static void main(String[] args) {

        //toString()
        Season1 spring = Season1.SPRING;
        System.out.println(spring.toString());

//        System.out.println(Season1.class.getSuperclass());
        System.out.println("\n");

        //values()
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }

        System.out.println("\n");

        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }

        //valueOf(String objName):返回枚举类中对象名是objName的对象
        Season1 winter = Season1.valueOf("WINTER");
        //如果没有objName的枚举类对象，则抛异常：IllegalArgumentException。
//        Season1 winter1 = Season1.valueOf("WINTER1");
        System.out.println(winter);

//        winter.show();

        winter.show();
    }


}

@MyAnnotation(value = "Hello")
interface  Info{
    void show();
}

//使用enum关键字定义枚举类
enum Season1 implements Info {

    //1.提供当前枚举类的对象，多个对象之间使用“ , ”隔开，末尾对象使用 “ ; ”结束
    SPRING("春天", "春暖花开") {
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天", "夏日炎炎") {
        @Override
        public void show() {
            System.out.println("宁静的夏天！");
        }
    },
    AUTUMN("秋天", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("大漠孤烟直！");
        }
    },
    WINTER("冬天", "银装素裹") {
        @Override
        public void show() {
            System.out.println("大约在冬季！");
        }
    };


    //2.声明Season类对象的属性 (实例变量)：private final修饰
    private final String seasonName;
    private final String seasonDesc;


    //3.私有化类的构造器 并给属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4.其他诉求：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    //4.1 其他诉求2：提供toString()方法
//    @Override
//    public String toString() {
//        return "Season1{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }


//    @Override
//    public void show() {
//        System.out.println("这是四季之一");
//    }
//}
}