package com.meng.java1;
/*
        1.泛型在继承方面的体现：


        2.通配符的使用

 */

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericTest {
    /*
    1.泛型在继承方面的体现：

        虽然类A是类B的父类，G<A> 和 G<B> 二者不具备子父类关系，二者是并列关系
             类A是类B的父类 ： A(G)是 B(G) 的父类，

     */

    @Test
    public void test1(){

        Object obj = null;
        String str = null;

        obj = str;

        Object[] arr = null;
        String[] str1 = null;

        arr = str1;


         //编译不通过
//        Date date = new Date();
//        str = date;

        ArrayList<Object> list1 = null;
        ArrayList<String> list2 = new ArrayList<>();
        //此时的list1和list2不具有字符类关系
        //编译不通过
//        list1 = list2;

        /*
        反证法：
        假设：list1 = list2 ;
             list1.add(123); 导致混入非String数据，出错
         */

        show(list1);
        show1(list2);


    }

    public void show (List<Object> list){

    }

    public void show1(List<String> list){

    }

    @Test
    public void test2(){
        AbstractList<String> list1 = null;
        List<String> list2  = null;
        ArrayList<String> list3 = null;

        list1 = list3;
        list2 = list3;

        List<String> list4 = new ArrayList<>();


    }

    /*
       2. 通配符的使用：
        通配符：?

        类A是类B的父类，G(A) 和G(B) 没有直接关系，二者是并列关系。 二者的共同父类是 G(?)

     */

    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;

        //编译通过
//        print(list1);
//        print(list2);

        List<String> list3 = new ArrayList<>();

        list3.add("AA");
        list3.add("BB");
        list3.add("CC");

        list = list3;

        //添加(写入) ：对于list<?> 不能向其内部添加数据
//        list.add("DD");
//        list.add("?");

        list.add(null);

        //写入(读取)： 允许读取数据，读取的数据类型是Object类型
        Object o = list.get(0);
        System.out.println(o);

    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    /*
      3. 有限制条件的通配符的使用：
            ? extends A：
                    G<? extends A> : 可以作为G(A) 和G(B)的父类，其中B是A的子类
            ? super A:
                    G<? super A> :可以作为G(A) 和G(B)的父类， 其中B是A的父类
     */
    @Test
    public void test4(){
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<Object>();


        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;

        //读取数据：
        list1 = list3;
        Person person = list1.get(0);
        //编译不通过
//        Student student = list1.get(0);

        list2 = list4;
        Object object = list2.get(0);
        //编译不通过
//        Person p = list2.get(0);

        //写入数据
        //编译不通过
//        list1.add(new Student());
//        list1.add(new Person());

        list2.add(new Person());
        list2.add(new Student());
    }


}
