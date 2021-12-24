package com.meng.Set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/** |----Collection接口：单列集合，用来存储一个一个的对象
 *              |----Set接口：存储无序的，不可重复的接口   -->高中讲的 “集合”
 *                      |----HashSet :作为Set接口的主要实现类，线程不安全的可以储存null值
 *                            |----LinkedHashSet.：作为HashSet的子类，遍历其内部数据时，可以按照添加的顺序遍历
 *                      |----TreeSet ： 可以按照添加对象的指定属性，进行排序
 *
 *      1 . Set接口中没有额外定义新的方法，使用的都是Collections中声明过的方法。
 *
 *      2.  要求：向Set中添加的数据，其所在类一定要重写equals()和hashCode()
 *          要求：重写的equals()和hashCode()尽可能保持一致性： 相等的对象必须具有相等的散列码
 *               重写两个方法的小技巧： 对象中用作equals()方法比较的 field， 都应该用来计算hashCode值
 */
public class SetTest {
        /*
         *一，Set:存储无序的，不可重复的数据
         * 以HashSet为例说明
         * 1.无序性 :不等于随机性.存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数组的哈希值决定的
         *
         * 2.不可重复性：保证添加的元素按照equals方法判断时，不能返回true，即：相同元素只能添加一个
         *
         *二，添加元素的过程，以HashSet为例：
         *      我们向HashSet中添加元素a，首先调用元素a所在类的HashCode()方法，计算元素a的哈希值
         *      此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置(即为：索引位置)，判断数
         *      组此位置上是否已有元素
         *             如果此位置上没有元素，则元素a添加成功   --->情况1
         *             如果此位置上有其他元素(或以链表形式存在的元素)，则比较两个元素的哈希值是否相同：
         *                  如果哈希值不相同，则元素a添加成功  --->情况2
         *                  如果哈希值相同，进而需要调用元素a所在类的equals()方法，
         *                      equals()返回true，则添加失败
         *                      equals()返回false，则元素a添加成功  --->情况3
         *
         *       对于添加成功的情况2和情况3而言：元素a 与已经存在指定索引位置上数据以链表的方式存储
         *       JDK 7 :元素a放到数组中，指向原来的元素
         *       JDK 8 :原来的元素在数组中，指向元素a
         *       总结： 七上八下
         *
         *       HashSet底层：数组+链表的形式存储
         */

    @Test
    public void test1(){

        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("C");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        set.add(634);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    
    }


    //LinkedHashSet 的使用
    //LinkedHashSet作为HashSet的子类，再添加数据的同时，每个数据还维护了两个引用，记录此数据前一个数据和后一个数据
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("C");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        set.add(634);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
