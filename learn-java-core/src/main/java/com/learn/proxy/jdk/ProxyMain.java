package com.learn.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author: yeguxin
 * @date: 2020/12/9
 * @description:
 */
public class ProxyMain {
    public static void main(String[] args) {
        // jdk动态代理需要被代理的类至少实现了一个接口
        Man targetObject = new Man();
        // 调用newProxyInstance方法中会生成一个代理类proxy0用来实现被代理类的接口.然后通过Proxy持有的InvocationHandler实现 TargetInvoker#invoker方法.
        IPerson iPerson  = (IPerson) Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), new PersonProxy(targetObject));
        iPerson.doAction();
    }
}
