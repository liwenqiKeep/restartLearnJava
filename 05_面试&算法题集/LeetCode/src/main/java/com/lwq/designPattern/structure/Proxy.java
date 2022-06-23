package com.lwq.designPattern.structure;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理模式
 *
 * @author liwenqi
 */
public class Proxy {

    public static void main(String[] args) {
        System.out.println("静态代理开始执行");
        executeStaticProxy();

        System.out.println("\r\njdk动态代理开始执行");
        executeJdkDynamicProxy();

        System.out.println("\r\ncglib动态代理开始执行");
        executeCglibDynamicProxy();
    }

    private static void executeCglibDynamicProxy() {
        CglibProxy<CglibTarget> proxy = new CglibProxy<>(new CglibTarget());
        CglibTarget target = (CglibTarget) proxy.getProxy();
        target.test();
    }

    private static void executeJdkDynamicProxy() {
        DynamicProxyInterface proxy = new DynamicProxyImplement();

        InvocationHandler handler = new DynamicProxyInvocationHandler<>(proxy);

        DynamicProxyInterface executeProxy =
                (DynamicProxyInterface) java.lang.reflect.Proxy.newProxyInstance(
                        proxy.getClass().getClassLoader(),
                        new Class[]{DynamicProxyInterface.class},
                        handler
                );
        executeProxy.test();

    }

    private static void executeStaticProxy() {
        StaticProxy proxy = new StaticProxy(new StaticProxyImplement());
        proxy.test();
    }

}

/**
 * 静态代理
 */
class StaticProxy {
    private final StaticProxyInterface proxyInterface;

    public StaticProxy(StaticProxyInterface proxyInterface) {
        this.proxyInterface = proxyInterface;
    }

    public void test() {
        System.out.println("代理类开始执行");
        proxyInterface.test();
        System.out.println("代理类结束执行");
    }
}

interface StaticProxyInterface {

    /**
     * 静态代理测试接口
     */
    void test();

}

class StaticProxyImplement implements StaticProxyInterface {

    /**
     * 静态代理测试接口
     */
    @Override
    public void test() {
        System.out.println("成功代理");
    }
}

/**
 * jdk 动态代理
 */
interface DynamicProxyInterface{
    /**
     * 代理测试接口
     */
    void test();
}

class DynamicProxyImplement implements DynamicProxyInterface {

    /**
     * 静态代理测试接口
     */
    @Override
    public void test() {
        System.out.println("成功代理");
    }
}

class DynamicProxyInvocationHandler<T> implements InvocationHandler{

    T target;
    public  DynamicProxyInvocationHandler(T target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Dynamic proxy invoke");
        return method.invoke(target,args);
    }
}

/**
 * cglib 动态代理
 *
 */
class CglibTarget{
    public void test(){
        System.out.println("目标类执行");
    }
}

class CglibProxy<T> implements MethodInterceptor{

    T target;
    public  CglibProxy(T target){
        this.target = target;
    }

    public Object getProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理前增强");
        Object end = methodProxy.invoke(target,objects);
        System.out.println("代理后增强");
        return end;
    }
}



