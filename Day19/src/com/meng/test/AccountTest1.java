package com.meng.test;

/**
 * @author
 * @description
 * @date 2021/11/29
 *
 *    银行有一个账户。
 *  * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打
 *  * 印账户余额。
 *  *
 *  * 分析：
 *  * 1.是否是多线程问题？ 是，两个储户线程
 *  * 2.是否有共享数据？ 是，账户(或账户余额)
 *  * 3.是否有线程安全问题？ 有
 *  * 4.需要如何考虑解决线程安全问题？ 同步机制：有三种方法
 */

//class Account1{
//    private  double balance;
//
//    public Account1(double balance) {
//        this.balance = balance;
//    }
//
//    public void deposit(double amt){
//        if (amt > 0){
//
//            balance += amt;
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println(Thread.currentThread().getName()+"存款成功！当前余额为："+balance);
//        }
//    }
//}

class Customer implements  Runnable{

    private  double balance ;

      //:方法一：lock锁
//    private ReentrantLock lock = new ReentrantLock();


    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            deposit(1000);
        }
    }

    //存钱方法
    //同步方法二：synchronized 同步方法
    public synchronized void deposit(double amt){
//        lock.lock();
        if (amt > 0){


            balance += amt;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"存款成功！当前余额为："+balance);
        }
//        lock.unlock();
    }
}

public class AccountTest1 {

    public static void main(String[] args) {

        Customer customer = new Customer();

        Thread t1= new Thread(customer);
        Thread t2= new Thread(customer);


        t1.setName("张三");
        t2.setName("李四");

        t1.start();
        t2.start();


    }
}
