package com.meng.java;

/**1.List接口框架
 *  |----Collection接口：单列集合，用来存储一个一个的对象
 *               |----list接口：存储有序的可重复的接口，   -->动态 “数组” ，替换原有的数据
 *
 *                    |----Arraylist:作为List接口的主要实现类；线程不安全的，效率高；底层使用Object[] elementData存储
 *                    |----LinkedList ：对于频繁的插入，删除操作；使用此类效率比ArrayList高，底层使用双向链表存储
 *                    |----Vector：  作为List接口的远古实现类，是线程安全的，效率低；底层使用Object[] elementData存储
 *
 *
 *           2.ArrayList源码分析：
 *
 *           2.1JDK 7情况下
 *           ArrayList list = new ArrayList();  //底层创建了长度是10的Object[]数组elementData
 *           list.add(123); // elementData[0] = new Integer(123);
 *           ...
 *           list.add(11);//如果此次的添加导致底层elementData数组容量不够，则扩容。
 *           默认情况下，扩容为原来的容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中。
 *
 *           结论：建议开发中使用带参的构造器 ArrayList list = new ArrayList(int capacity);
 *
 *           2.2JDK 8情况下ArratList的变化：
 *           ArrayList list = new ArrayList();  //底层Object[] elementData初始化为{}，并没有创建长度为10的数组
 *
 *           list.add(123)； //第一次调用add()时，底层才创建了长度为10的数组，并将数据123添加到elementData[0]
 *           ...
 *           后续的添加于扩容操作与JDK 7无异。
 *
 *
 *           小结：JDK 7中的ArrayList的对象的创建类似于单例模式的饿汉式；而JDK 8中的ArrayList的对象的创建类似与单例模式中的懒汉式，延迟了数组的创建，节省内存。
 *
 *           3.LinkedList源码分析：
 *           LinkedList list = new LinkedList(); //内部声明了Node类型的first和last属性，默认值为null
 *           list.add(123);  // 将123封装到Node中，创建了Node对象
 *
 *           其中，定义Node为：体现了LinkedList双向链表的说法
 *
 *           private static class Node<E> {
                E item;
                Node<E> next;
                Node<E> prev;

               Node(Node<E> prev, E element, Node<E> next) {
 *             this.item = element;
 *             this.next = next;
 *             this.prev = prev;
 *         }
 *     }
 *
 *
 *
 *   面试题：ArrayList ，LinkedList， Vector三者的异同？
 *   相同点：三个类都实现了List接口，存储的特点相同：存储有序的，可重复的数据
 *   不同点：见上
 *
 *
 */
public class ListTest {

}