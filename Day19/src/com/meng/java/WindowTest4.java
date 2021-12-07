package com.meng.java;

/**
 * @author
 * @description
 * @date 2021/11/28
 *
 * 使用同步方法处理继承Thread类的方式中的线程安全问题
 *
 */
public class WindowTest4 {

    public static void main(String[] args) {

        Window2 w1 = new Window2();
        Window2 w2 = new Window2();
        Window2 w3 = new Window2();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();

    }

}

class Window2 extends Thread{

    private static int ticket  = 100;


    @Override
    public void run() {

        while (true){
            show();

        }
    }

    private static synchronized void show(){ // 同步监视器：Window2.class
    //private synchronized void show(){//同步监视器：w1,w2,w3 . 此种解决方法是错误的
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            ticket--;
        }
    }
}
