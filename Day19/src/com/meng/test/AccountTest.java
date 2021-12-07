package com.meng.test;

/**
 * @author
 * @description
 * @date 2021/11/29
 *
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打
 * 印账户余额。
 *
 * 分析：
 * 1.是否是多线程问题？ 是，两个储户线程
 * 2.是否有共享数据？ 是，账户(或账户余额)
 * 3.是否有线程安全问题？ 有
 * 4.需要如何考虑解决线程安全问题？ 同步机制：有三种方法
 */

 class Account{

    private double balance ;

    public Account(double balance) {
        this.balance = balance;
    }

    //存钱
    public synchronized void deposit(double amt){
        if (amt > 0){

            balance += amt;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"存款成功！当前余额为："+balance);
        }
    }

}

class UserAccount extends Thread {

    private Account acct;

//    private ReentrantLock lock = new ReentrantLock();

    public UserAccount(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {


        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        lock.lock();

        for (int i = 0; i < 3; i++) {
                acct.deposit(1000);
        }

//        lock.unlock();
    }


}


public class AccountTest {

    public static void main(String[] args) {

        Account account = new Account(0);

        UserAccount u1 = new UserAccount(account);
        UserAccount u2 = new UserAccount(account);


        u1.setName("储户1");
        u2.setName("储户2");

        u1.start();
        u2.start();
    }
}
