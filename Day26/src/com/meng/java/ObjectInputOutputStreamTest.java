package com.meng.java;

import org.junit.Test;

import java.io.*;
/*
    对象流的使用：
    1.ObjectInputStream 和 ObjectOutputStream
    2.作用： 用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。

    3.要想满足一个Java对象是可序列化的，需要满足相应的要求。具体要求见Person.java

    4.序列化机制：
      对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种二进制流持久地保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点。
      //当其它程序获取了这种二进制流，就可以恢复成原来的Java对象
 */
public class ObjectInputOutputStreamTest {

    /*
        序列化过程： 将内存中的Java对象保存到磁盘中或通过网络传输出去
        使用ObjectOutputStream实现
     */
    @Test
    public void test1ObjectOutputStream(){
        ObjectOutputStream oos = null;
        try {
            //1.造流，造对象
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));

            //2.写入操作
            oos.writeObject(new String("我在尚硅谷学Java！"));
            oos.flush();

            oos.writeObject(new Person("赵四",66));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null){
                //3.资源的关闭
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        反序列化：将磁盘文件中的对象还原成内存中一个java对象
        使用ObjectInputStream来实现
     */
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            //1.造流，造对象
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            //2.读取操作
            Object readObject = ois.readObject();
            String str = (String) readObject;

            Object obj = ois.readObject();
            Person p = (Person) obj;

            System.out.println(str);
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null){
                //3.资源的关闭
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
