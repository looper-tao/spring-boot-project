package com.learn.lock.example;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: yeguxin
 * @date: 2021/4/16
 * @description: 交替打印
 *
 *  LockSupport 线程工具类简单记录
 */
public class BaseLock02 {
    private static String[] numList = {"1","2","3","4","5","6","7"};
    
    private static String[] strList = {"A","B","C","D","E","F","G"};
    
    static Thread t1 = null;
    static Thread t2 = null;
    
    public static void main(String[] args) {
        t1 = new Thread1();
        t2 = new Thread2();
        
        t1.start();
        t2.start();
    }
    
    public static class Thread1 extends Thread{
        @Override
        public void run() {
            LockSupport.park();
            for(String str: numList){
                System.out.print(str+"  ");
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }
    }
    
    public static class Thread2 extends Thread{
        @Override
        public void run() {
            for(String str: strList){
                System.out.print(str+"  ");
                LockSupport.unpark(t1);
                LockSupport.park();
            }
        }
    }
    
}
