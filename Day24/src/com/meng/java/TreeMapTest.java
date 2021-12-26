package com.meng.java;


import org.junit.Test;

import java.util.*;

public class TreeMapTest {
        /*

        //向TreeMap中添加key-value，要求key必须是由一个类创建的对象
        //因为要按照key进行排序：自然排序， 定制排序

         */

    @Test
    public void test1(){
        TreeMap map = new TreeMap();

        map.put(new User("Tom",12),66);
        map.put(new User("Jack",22),99);
        map.put(new User("Mary",35),89);
        map.put(new User("Jerry",66),100);

        Set keySet = map.entrySet();
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey()+"---->"+entry.getValue());
        }
    }

    //定制排序：
    @Test
    public void test2(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof  User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                }
                throw new RuntimeException("输入的类型不匹配！");
            }
        });

        map.put(new User("Tom",12),66);
        map.put(new User("Jack",22),99);
        map.put(new User("Mary",35),89);
        map.put(new User("Jerry",66),100);

        Set keySet = map.entrySet();
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey()+"---->"+entry.getValue());
        }
    }

}
