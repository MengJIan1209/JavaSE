package com.meng.Set;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 */
public class TreeSetTest {

    /*
     * 1.向TreeSet中添加的数据，要求是相同类的对象
     *
     * 2.两种排序方式：自然排序(实现Comparable接口)和定制排序(Comparator)
     *
     * 3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals()
     * 4.定制排序中，比较两个对象是否相同的标准为：compare()返回0，不再是equals()
     *
     */

    @Test
    public void test1(){

        TreeSet set = new TreeSet();

//        //失败：不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new User("Jack",12));
//
//        //举例一：
//        set.add(123);
//        set.add(22);
//        set.add(38);
//        set.add(-123);

        //举例二：
        set.add(new User("Tom",12));
        set.add(new User("Jack",33));
        set.add(new User("Mike",5));
        set.add(new User("Jim",66));
        set.add(new User("Scott",24));
        set.add(new User("Scott",38));

        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }

    @Test
    public void test2(){
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                }else{
                    throw new RuntimeException("输入的数据不匹配");
                }
            }
        };

        TreeSet set = new TreeSet(com);

        set.add(new User("Tom",12));
        set.add(new User("Jack",33));
        set.add(new User("Mike",5));
        set.add(new User("Jim",66));
        set.add(new User("Scott",24));
        set.add(new User("Mary",38));
        set.add(new User("Scott",38));

        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }

}
