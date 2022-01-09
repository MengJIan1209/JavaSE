package com.meng.java;

import org.junit.Test;

import java.util.Random;

/*
    通过反射创建对应的运行时类的对象
 */
public class NewInstanceTest  {

   @Test
    public void test1() throws Exception{
       Class<Person> clazz = Person.class;

       /*
         newInstance() : 通过此方法，创建对应的运行时类的对象。调用了运行时类的空参构造器

         要求此方法正常的创建运行时类的对象，要求：
         1.运行时类必须提供空参构造器
         2.空参的构造器的访问权限必须得够。通常设置为public

         在JavaBean中要求提供一个public的空参的构造器。原因：
         1.便于通过反射，创建运行时类的对象
         2.便于子类继承此运行时类时，默认使用super()时，保证父类有此构造器

        */
       Person p = clazz.newInstance();
       System.out.println(p);

   }

   //体会反射的动态性
   @Test
   public void test2() throws Exception {
      for (int i = 0; i < 100; i ++){
         int num = new Random().nextInt(3);// 0 1 2
         String classPath = "";
         switch (num){
            case 0:
               classPath = "java.util.Date";
               break;
            case 1:
               classPath = "java.lang.Object";
               break;
            case 2:
               classPath = "com.meng.java.Person";
               break;
         }

         Object obj = getInstance(classPath);
         System.out.println(obj);
      }



   }
   /*
   创建一个指定类的对象。
   classPath：指定类的全类名
    */
   public Object getInstance(String classPath) throws Exception {
      Class clazz = Class.forName(classPath);
      return clazz.newInstance();
   }


}
