package com.learn.nested;

/**
 * @author: yeguxin
 * @date: 2020/6/22
 * @description: 成员内部类: 定义在类内部的非静态类，就是成员内部类
 *
 * 成员内部类不能定义静态方法和变量(final 修饰的
 * 除外)。这是因为成员内部类是非静态的，类初始化的时候先初始化静态成员，如果允许成员内
 * 部类定义静态变量，那么成员内部类的静态变量初始化顺序是有歧义的
 */
public class MemberNestedOut {
    private static int a;
    private int b;
    
    public class Inner {
        public void print() {
            System.out.println(a);
            System.out.println(b);
        }
    }
}
