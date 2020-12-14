package com.learn.proxy.cglib;

/**
 * @author: yeguxin
 * @date: 2020/12/10
 * @description:
 */
public class CglibProxyMain {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Cat cat = (Cat) cglibProxy.getCglibProxy(new Cat());
        cat.eat();
    
    }
}
