package com.meng.java;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*


 */
public class ReflectionTest {
        //反射之前对于Person类的操作
    @Test
    public void test1(){
        //1.创建Person类的对象
        Person p1 = new Person("tom",12);
//        Person p2 = new Person("Jack");
        //2.通过对象调用其内部的属性，方法
        p1.age = 10;
        p1.show();
//        p1.showNation("中国");
        System.out.println(p1.toString());
        //在Person类外部，不可以通过Person类的对象调用Person类内部私有的结构
        //比如，name，showNation()以及私有的构造器

    }

    //有了反射以后，对于Person的操作
    @Test
    public void test2() throws Exception {
        //1.通过反射,创建Person类的对象
        Class clazz = Person.class;
        Constructor cons = clazz.getConstructor(String.class, int.class);

        Object obj = cons.newInstance("Jack", 12);
        Person p = (Person) obj;
        System.out.println(p.toString());

        //2.通过反射，调用对象指定的属性和方法
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());

        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("----------------------------------------");

        //通过反射，可以调用Person类的私有结构：比如，私有的构造器，属性，方法
        //调用私有的构造器
        Constructor constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Person p1 = (Person)constructor.newInstance("Jerry");
        System.out.println(p1.toString());

        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"LiLei");
        System.out.println(p1);

        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1,"中国"); //相当于p1.showNation("中国");
        System.out.println(nation);

    }

    //疑问：通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用哪个？
    //建议：用直接new的方式
    //什么时候会使用反射的方式：反射的特征：动态性。
    //疑问：有了反射以后与面向对象当中的封装性是不是矛盾的？如何看待这两个技术？
    //不矛盾。封装性是建议调用公共的结构，不建议调用私有的结构。
    //       反射是能不能调用调用私有的结构

    /*
        关于java.lang.Class类的理解
        1.类的加载过程
        程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
        接着我们使用java.exe命令对某个文件进行解释运行。相当于将某个字节码文件加载到内存中。
        此过程就成为类的加载。加载到内存中的类，我们就称为运行时类，此运行时类，就是作为Class
        的一个实例。

        2.换句话说：Class的实例就对应着一个运行时类
        3.加载到内存中的运行时类，会缓存一定的时间。在此时间内，我们可以通过不同的方式，来获取
        此运行时类。
     */

    //获取Class实例的四种方式
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class clazz = Person.class;
        System.out.println(clazz);

        //方式二：通过运行时类的对象,调用getClass()
        Person p1 = new Person();
        Class clazz1 = p1.getClass();
        System.out.println(clazz1);

        //方式三：调用Class的静态方法：forName(String classPath)
        Class clazz2 = Class.forName("com.meng.java.Person");
//        clazz2 = Class.forName("java.lang.String");
        System.out.println(clazz2);

        System.out.println(clazz == clazz1); //true
        System.out.println(clazz == clazz2); //true

        //方式四：使用类的加载器：ClassLoader(了解)
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz3 = classLoader.loadClass("com.meng.java.Person");
        System.out.println(clazz3);

        System.out.println(clazz == clazz3);

    }

    //Class实例可以是哪些类的说明
    @Test
    public void test4(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;
        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }

}
