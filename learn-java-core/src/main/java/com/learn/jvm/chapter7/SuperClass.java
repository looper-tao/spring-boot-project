package com.learn.jvm.chapter7;

/**
 *
 * @author: yeguxin
 * @date: 2019/11/21
 * @description:
 */
public class SuperClass {
    
    static {
        System.out.println("SuperClass init!");
    }
    
    public static int value = 123;
    
    public static final String HELLOWORLD = "hello world";
    
}