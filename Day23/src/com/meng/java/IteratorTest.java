package com.meng.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *     集合元素的遍历操作： 使用迭代器Iterator接口
 *
 *     1.内部的方法：hasNext() 和 next()
 *     2.集合对象每次调用iterator()方法都会得到一个全新的迭代器对象
 *       默认游标都在集合的第一个元素之前
 *     3.内部定义了remove()，可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()
 */
public class IteratorTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Tom",20));
        coll.add(new String("Jerry"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        //方式一：
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        //报异常：NoSuchElementException
////        System.out.println(iterator.next());

        //方式二：不推荐
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

        //方式三：推荐
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }

    @Test
    public void test2(){

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        //删除集合中“Tom”
        while (iterator.hasNext()){
            Object obj = iterator.next();
            if ("Tom".equals(obj)){
                iterator.remove();
            }

        }

        iterator = coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
