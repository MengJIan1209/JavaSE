package com.meng.java;

/**
 * @author
 * @description
 * @date 2021/11/26
 *
 * 例子：创建三个窗口卖票，总票数为100张.使用实现Runnable接口的方式
 *
 *
 * 1.问题：在卖票过程中出现了重票，错票--->出现了线程安全问题
 * 2.问题出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票
 * 3.如何解决：当一个线程a在操作ticket的时候，其他线程不能参与进来，知道线程a操作完ticket时，
 *           其他线程才可以开始操作ticket，这种情况即使线程a出现了阻塞，也不能被改变
 * 4.在Java中我们通过同步机制，来解决线程的安全问题
 *
 *      方式一：同步代码块
 *
 *          synchronized(同步监视器){
 *              //需要被同步的代码
 *
 *          }
 *          说明：1.操作共享数据的代码，即为需要被同步的代码    --->不能包含代码多了，也不能包含代码少了
 *               2.共享数据，多个线程共同操作的变量，比如，ticket就是共享数据
 *               3.同步监视器：俗称：锁。 任何一个类的对象，都可以充当锁
 *                           要求：多个线程必须要公用一把锁
 *
 *               补充：实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器
 *
 *5.同步的方式，解决了线程的安全问题   --->好处
 *  操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低  --->坏处
 *
 */
public class WindowTest1 {

    public static void main(String[] args) {

        MengThread mengThread = new MengThread();

        Thread t1 = new Thread(mengThread);
        Thread t2 = new Thread(mengThread);
        Thread t3 = new Thread(mengThread);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();




    }

}

class MengThread implements Runnable{

    private  int ticket = 100;
//    Object obj = new Object();

    @Override
    public void run() {
        while (true){

            synchronized(this){//此时的this：唯一的MengThread的对象  //synchronized (obj) {
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "卖出的票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
