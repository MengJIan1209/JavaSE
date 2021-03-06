package com.meng.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
    动态代理的举例：

 */
interface Human{

    String getBelief();

    void eat(String food);

}

class  HumanUtil{

    public void method1(){
        System.out.println("====通用方法1====");
    }

    public void method2(){
        System.out.println("====通用方法2====");
    }

}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "我相信我是超人";
    }

    @Override
    public void eat(String food) {
        System.out.println("我最爱吃的是: "+food);
    }
}

/*
  要想实现动态代理，需要解决的问题：
  问题一：如何根据加载到内存中的代理类，动态的创建一个代理类及其对象
  问题二：当通过代理类的对象去调用方法时，如何动态的去调用被代理类中的同名方法。
 */

class ProxyFactory{
    //调用此方法，返回一个代理类的对象。解决问题一
    public static Object getProxtInstance(Object obj){ // obj : 被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }

}

class MyInvocationHandler implements InvocationHandler {
    private Object obj; // 需要使用被代理类的对象赋值

    public void bind(Object obj){
        this.obj = obj;
    }

    //当我们通过代理类的对象，调用方法a时，就会自动调用如下的方法：invoke()
    //将被代理类要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            HumanUtil util = new HumanUtil();
            util.method1();

            //method：即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
            //obj：被代理类的对象
            Object returnValue = method.invoke(obj,args);
            //上述方法的返回值就作为当前类中invoke()方法的返回值。

            util.method2();

            return returnValue;
    }
}

public class ProxyTest {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        //proxtInstance : 代理类的对象
        Human proxtInstance = (Human) ProxyFactory.getProxtInstance(superMan);

        //当通过代理类对象调用方法时，会自动的执行被代理类中同名的方法
        String belief = proxtInstance.getBelief();
        System.out.println(belief);
        proxtInstance.eat("米线");

        System.out.println("-------------------------");

        NikeClothFactory nike = new NikeClothFactory();
        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxtInstance(nike);

        proxyClothFactory.produceCloth();


    }
}
