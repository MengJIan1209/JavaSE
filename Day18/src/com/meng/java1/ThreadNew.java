package com.meng.java1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author
 * @description
 * @date 2021/11/30
 *
 * 创建线程的方式之三：实现Callable接口的方式。    ---->JDK5.0新增
 *
 *
 * 如何理解实现Callable接口的方式创建多线程比实现Runnable接口的方式实现多线程方式强大？
 * 1.call()可以有返回值
 * 2.call()可以抛出异常，被外面的操作捕获，获取异常的信息
 * 3.Callable是支持泛型的
 *
 *
 *1.创建一个实现Callable接口的实现类
 *
 *
 */

class NewThread implements Callable{
    //实现call()方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum  = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(i);
                sum +=i;
            }
        }
        return sum;
    }
}




public class ThreadNew {

    public static void main(String[] args) {

        //3.创建Callable接口实现类的对象
        NewThread newThread = new NewThread();

        //4.将此Callable接口的实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask task = new FutureTask(newThread);

        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread类的对象，并调用start()方法
        new Thread(task).start();

        try {
            //6.获取Callable中call方法的返回值
            //get()方法返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值
            Object sum = task.get();
            System.out.println("总和为："+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}



