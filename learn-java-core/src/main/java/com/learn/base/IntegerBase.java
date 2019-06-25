package com.learn.base;

/**
 * @Author: taozhengzhi
 * @Date: 2019/6/19 下午4:56
 * @Version 1.0
 */
public class IntegerBase {
    
    public static void compareToTest(int a,int b){
        Integer integer1 = Integer.valueOf(a);
    
        Integer integer2 = Integer.valueOf(b);
        
        System.out.println(integer1.compareTo(integer2));
    }
    
    public static void main(String[] args) {
        IntegerBase.compareToTest(2,1);
    }
}
