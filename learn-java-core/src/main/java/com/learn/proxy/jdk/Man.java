package com.learn.proxy.jdk;

/**
 * @author: yeguxin
 * @date: 2020/12/9
 * @description:
 */
public class Man implements IPerson {
    public Man() {
    }
    
    public Man(String a) {
        System.out.println("a = " + a);
    }
    
    public Man(Integer n) {
        System.out.println("n = " + n);
    }
    
    @Override
    public void doAction() {
        System.out.println("男人的行为");
    }
}
