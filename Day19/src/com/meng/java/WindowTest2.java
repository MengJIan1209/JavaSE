package com.meng.java;

/**
 * @author
 * @description
 * @date 2021/11/28
 *
 * 使用同步代码块解决继承Thread类的方式的线程安全问题
 *
 * 例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
 *
 *说明：在继承Thread类创建多线程的方式，慎用this充当同步监视器，考虑使用当前类充当同步监视器
 *
 */
public class WindowTest2 {

    public static void main(String[] args) {

        Window1 w1 = new Window1();
        Window1 w2 = new Window1();
        Window1 w3 = new Window1();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();

    }

}

class Window1 extends Thread{

    private static int ticket  = 100;
    private static Object obj  = new Object();

//    public void setTicket(int ticket) {
//        this.ticket = ticket;
//    }
//
//    public int getTicket() {
//        return ticket;
//    }

    @Override
    public void run() {

        while (true){
            //正确的方式
            synchronized(Window1.class) {//Window1.class只会加载一次
                //错误的方式：此时的this，代表着w1,w2,w3三个对象
            //synchronized(this){
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

