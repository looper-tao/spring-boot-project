package com.learn.nested;

/**
 * @author: yeguxin
 * @date: 2020/6/22
 * @description: 静态内部类: 定义在类内部的静态类，就是静态内部类。
 *
 * 静态内部类可以访问外部类所有的静态变量和方法，即使是 private 的也一样
 * 静态内部类和一般类一致，可以定义静态变量、方法，构造方法等。
 * 其它类使用静态内部类需要使用“外部类.静态内部类”方式，如下所示:
 * Out.Inner inner = new Out.Inner();
 * inner.print();
 * Java 集合类 HashMap 内部就有一个静态内部类 Entry。Entry 是 HashMap 存放元素的抽象， HashMap 内部维护 Entry 数组用了存放元素，但是 Entry 对使用者是透明的。像这种和外部 类关系密切的，且不依赖外部类实例的，都可以使用静态内部类。
 */
public class StaticNestedOut {
    private static int a;
    private int b;
    
    public static class Inner {
        public void print() {
            System.out.println(a);
        }
    }
}
