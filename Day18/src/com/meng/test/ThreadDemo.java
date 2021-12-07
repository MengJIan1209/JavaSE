package com.meng.test;

/**
 * @author
 * @description
 * @date 2021/11/25
 *
 *
 * 练习：创建两个分线程，一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数
 *
 */
public class ThreadDemo {

    public static void main(String[] args) {

//        ThreadTest t1 = new ThreadTest();
//        t1.start();
//
//        ThreadTest1 t2 = new ThreadTest1();
//        t2.start();


        new Thread(){
            public void run(){
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();

        new Thread(){
            public void run(){
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();

    }

}

class ThreadTest extends Thread{


    public void run(){
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

}

class ThreadTest1 extends  Thread{

    public void run(){
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

}
