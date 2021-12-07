package com.meng.java;

/**
 * @author
 * @description
 * @date 2021/11/25
 *
 * 多线程的创建：
 * 方式一：继承Thread类的子类
 *      1.创建一个继承于Thread类的子类
 *      2.重写Thread类的run()方法     -->将此线程执行的操作声明在run()方法中
 *      3.创建Thread类的子类的对象
 *      4.通过此对象调用start()
 *
 * 例子：遍历100以内所有的偶数
 *
 */
public class ThreadTest {

    public static void main(String[] args) {

//        MyThread myThread = new MyThread();
        //3.创建Thread类的子类的对象
        MyThread myThread = new MyThread();

        //4.通过此对象调用start() : ①：启动当前线程 ②：调用当前线程的run()方法
        myThread.start();

        //问题一：我们不能通过直接调用run()的方式启动一个线程
//        myThread.run();

        //问题二：在启动一个线程，遍历100以内的偶数。不可以继续让已经start()的线程去执行，会报IllegalThreadStateException异常
//        myThread.start();

        //我们需要重新创建一个线程的对象
        MyThread myThread1 = new MyThread();
        myThread1.setName("");
        myThread1.start();

//        System.out.println("Hello");
        //如下的操作仍然在main线程中执行
        for (int i = 0; i < 100 ; i++){
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName()+":"+i+"----main()----");
            }
        }
    }




}

//1.创建一个继承于Thread类的子类
class MyThread extends Thread{

    //2.重写Thread类的run()方法
    @Override
    public void run() {
        for (int i = 0; i < 100 ; i++){
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}
