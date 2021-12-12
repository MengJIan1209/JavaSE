package com.meng.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 *       Collection接口中声明的方法的测试:
 *
 *       向Collection接口的实现类中添加数据obj时，要求obj所在类要重写equals()
 */
public class CollectionTest1 {

    @Test
    public void test1(){

        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);

//        Person p = new Person("Tom",20);
        coll.add(new Person("Tom",20));
        coll.add(new String("Jerry"));
        coll.add(false);

        //contains(Object obj):判断当前集合中是否包含obj
        //我们回去调用obj对象所在类的equals()方法
        boolean contains = coll.contains(123);
        System.out.println(contains);

        System.out.println(coll.contains(new String("Jerry")));
        System.out.println(coll.contains(new Person("Tom",20)));//false --->true

        //2.containsAll(Collection coll1):判断形参coll1中的所有数据是否都在当前集合中
        Collection coll1 = Arrays.asList(123,4567);
        boolean containsAll = coll.containsAll(coll1);
        System.out.println(containsAll);

    }

}
