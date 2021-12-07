package com.meng.java;

/**
 * @author
 * @description
 * @date 2021/11/28
 *
 *关于同步方法的总结：
 *
 * 1.  同步方法仍然涉及到同步监视器，只是不需要显式的声明
 * 2.  非静态的同步方法，同步监视器是this
 *     静态的同步方法，同步监视器是当前类本身
 *
 *
 */
public class WindowTest3 {

    public static void main(String[] args) {

        MengThread mengThread1 = new MengThread();

        Thread t1 = new Thread(mengThread1);
        Thread t2 = new Thread(mengThread1);
        Thread t3 = new Thread(mengThread1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();




    }

}

class MengThread1 implements Runnable{

    private  int ticket = 100;

    @Override
    public void run() {
        while (true){
            show();

        }
    }

    public synchronized void show(){//同步监视器：this
        //synchronized(this){
            if (ticket > 0) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "卖出的票号为：" + ticket);
                ticket--;
            }
       // }
    }
}
