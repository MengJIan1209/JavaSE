package com.meng.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *       Collection接口中声明的方法的测试:
 *
 *       结论：
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

    @Test
    public void test2(){
        //3.remove(Object obj): 从当前集合中移除obj元素

        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new Person("Tom",20));
        coll.add(new String("Jerry"));
        coll.add(false);

        coll.remove("Jerry");
        System.out.println(coll);

        coll.remove(new Person("Tom",20));
        System.out.println(coll);

        //4.removeAll(Collection coll1 ): 从当前集合中移除coll1中所有元素
        Collection coll1 = Arrays.asList(123,4567);
        coll.removeAll(coll1);
        System.out.println(coll);
    }


    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Tom",20));
        coll.add(new String("Jerry"));
        coll.add(false);

//        Collection coll1 = Arrays.asList(123,456,789);
//
//        //5.retain(Collection coll1 ): 交集：获取coll1和当前集合的交集，并返回给当前集合
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //6.equals(Object obj): 要想返回true，需要当前集合和形参集合的元素都相同
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new Person("Tom",20));
        coll1.add(new String("Jerry"));
        coll1.add(false);

        System.out.println(coll.equals(coll1));
    }

    @Test
    public void test4(){

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Tom",20));
        coll.add(new String("Jerry"));
        coll.add(false);

        //7.hashCode(): 返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.集合 ---> 数组： toArray():
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //拓展：数组 ---> 集合？ :调用Arrays类的静态方法asList()
        List<String> strings = Arrays.asList(new String[]{"aa", "bb", "cc"});
        System.out.println(strings);

        List<int[]> arr1 = Arrays.asList(new int[]{123,456});
        System.out.println(arr1.size()); //1

        List arr2 = Arrays.asList(new Integer[]{123,456});
        System.out.println(arr2.size()); //2
        System.out.println(arr2);

        //9.iterator():返回Iterator接口的实例，用于遍历集合元素，放在IteratorTest.java中测试
    }
}
