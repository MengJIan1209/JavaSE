package com.meng.java;

/*
 一、Map的实现类的结构：
    |----Map:双列数据， 存储key - value 对的数据。     ---类似于高中的函数 y = f(x)
         |----HashMap：   作为Map的主要实现类：线程不安全的，效率高。存储null的key和value
              |----LinkedHashMap：保证在遍历map元素时，可以按照添加的顺序实现遍历。
                                  原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素，
                                       对于频繁的遍历操作，此类执行效率高于HashMap。
         |----TreeMap： 保证按照添加的key - value对 进行排序，实现排序遍历。 此时考虑key的自然排序或定制排序
                            底层使用红黑树
         |----HashTable： 作为古老的实现类  ：线程安全的，效率低。 不能存储null的key和value
              |----Properties：


         HashMap的底层：  数组+链表(JDK 7.0及之前)
                         数组+链表+红黑树(JDK 8.0)

    面试题：1. HashMap的底层实现原理？
           2. HashMap和Hashtable的异同？
           3. CurrentHashMap 与 Hashtable的异同？

    二、Map结构的理解：
      Map中的key： 无序的，不可重复的，使用Set存储虽有的key   --->key所在的类要重写equals()和hashCode()方法 (以HashMap为例)
      Map中的value：无序的，可重复的，使用Collection存储所有的value   --->value所在的类要重写equals()
      一个键值对：key-value构成一个Entry对象
      Map中的entry：无序的，不可重复的，使用Set存储所有的entry


    三、HashMap的底层实现原理？以JDK 7为例：
        HashMap map = new HashMap();
        在实例化以后，底层创建了一个长度为16的一维数组 Entry[] table。
        ...可能已经执行过很多次put...
        map.put(key1，value1);
        首先，调用key1所在类的hashCode()计算key1的哈希值，此哈希值经过某种算法后，得到在Entry数组中存放的位置。
        如果此位置上的数据为空，此时的key1-value1已经添加成功。  ---情况1
        如果此位置上的数据不为空，(意味着此位置上存在一个或多个数据(以链表的形式存在))，比较key1和已经存在的一个或多个数据的哈希值。
                    如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功。   ---情况2
                    如果key1的哈希值与已经存在的某一个数据(key2-value2)的哈希值相同，继续比较；调用key1所在类的equals(key2)
                                如果equals()返回false:此时的key1-value1添加成功   --->情况3
                                如果equals()返回true：使用value1 替换 value 2

         补充：关于情况2和情况3，此时的key1-value1和原来的数据以链表的方式存储

         在不断地添加过程中，会涉及到扩容问题，默认的扩容方式，扩容为原来的2倍，并将原来的数据复制过来

         JDK 8相较于JDK 7在底层实现方面的不同，
         1.new HashMap();  底层没有创建一个长度为16的数组
         2.JDK 8底层数组是Node[] ,不是Entry[]
         3.首次调用put()方法时，底层创建长度为16的数组
         4.JDK7底层结构只有数组+链表。JDK 8中底层结构：数组+链表+红黑树
           当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8，且当前的数组的长度 > 64时
           此时此索引位置上的所有数据改为使用红黑树的形式存储。

 */

import org.junit.Test;

import java.util.HashMap;

public class MapTest {

    @Test
    public void test1(){
        HashMap map = new HashMap();


    }

}
