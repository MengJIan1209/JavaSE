package com.meng.test;

/**
 * @author
 * @description
 * @date 2021/11/29
 *
 * 线程通信的例子：使用两个线程打印1-100.线程1，线程2 交替打印
 *
 * 涉及到的三个方法：
 * wait():  一旦执行此方法，当前线程就会进入阻塞状态，并释放同步监视器
 * notify():   一旦执行此方法，就会唤醒被wiat的一个线程，如果有多个线程被wait，就会唤醒优先级比较高的那个。
 * notifyAll():   一旦执行此方法，就会唤醒所有被wait的线程
 *
 *
 * 说明：
 * 1.wait() ，notify() , notifyAll()三个方法必须使用在同步代码块或同步方法中
 * 2.wait() ，notify() , notifyAll()三个方法的调用者必须是同步代码块或者同步方法中的同步监视器。
 *         否则会出现IllegalMonitorStateException异常
 * 3.wait() ，notify() , notifyAll()三个方法是定义在java.lang.Object类中
 *
 *
 * 面试题：sleep()和wait()区别
 * 相同点：一旦执行方法，都可以使当前线程进入阻塞状态
 * 不同点：①：两个方法声明位置不同，sleep()声明在Thread类中，wait()声明在Object类中
 *       ②：调用的要求不同：sleep()可以在任何需要的场景下调用，wait()必须在同步代码块或同步方法中
 *       ③：关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep()不会释放锁，wait()会释放锁
 *
 */
public class CommunicationTest {

    public static void main(String[] args) {

        Mythread n1 = new Mythread();

        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n1);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();

    }
}

class Mythread implements Runnable{

    private  int number = 1;
//    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {

        while (true) {
            synchronized (this) {

                notify();

                if (number <= 100){
     //               lock.lock();

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        //使得调用如下wait()方法的线程进入阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //               lock.unlock();
                }else{
                    break;
                }
            }
        }
    }
}
