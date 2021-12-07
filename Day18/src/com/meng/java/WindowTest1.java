//package com.meng.java;
//
///**
// * @author
// * @description
// * @date 2021/11/26
// *
// * 例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
// *
// * 存在线程安全问题，待解决
// *
// */
//public class WindowTest1 {
//
//    public static void main(String[] args) {
//
//        MengThread mengThread = new MengThread();
//
//        Thread t1 = new Thread(mengThread);
//        Thread t2 = new Thread(mengThread);
//        Thread t3 = new Thread(mengThread);
//
//        t1.setName("窗口1");
//        t1.start();
//
//        t2.setName("窗口2");
//        t2.start();
//
//        t3.setName("窗口3");
//        t3.start();
//
//    }
//
//}
//
//class MengThread implements Runnable{
//
//    private  int ticket = 100;
//
//    @Override
//    public void run() {
//        while (true){
//            if (ticket > 0){
//                System.out.println(Thread.currentThread().getName()+"卖出的票号为："+ticket);
//                ticket--;
//            }else{
//                break;
//            }
//        }
//    }
//}
