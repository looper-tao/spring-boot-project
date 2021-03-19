package com.learn.lock.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yeguxin
 * @date: 2021/3/8
 * @description:
 *
 * 交替打印
 */
public class BaseLock01 {

    private static ReentrantLock lock = new ReentrantLock();
    
    private static Condition condition1 = lock.newCondition();
    
    private static Condition condition2 = lock.newCondition();
    
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    
    private static String[] numList = {"1","2","3","4","5","6","7"};
    
    private static String[] strList = {"A","B","C","D","E","F","G"};
    
    public static void main(String[] args) {
        Thread t1 = new PrintThread1();
        Thread t2 = new PrintThread2();
        
        t1.start();
        t2.start();
    }
    
    public static class PrintThread1 extends Thread{
        @Override
        public void run() {
            try {
                countDownLatch.await();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            
            lock.lock();
    
            for(String str:numList) {
                System.out.print(str);
    
                condition2.signal();
                try {
                    condition1.await();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
            condition2.signal();
            
            lock.unlock();
        }
    }
    
    static class PrintThread2 extends Thread{
        @Override
        public void run() {
            lock.lock();
            
            for(String str:strList) {
                System.out.print(str);
                
                countDownLatch.countDown();
                
                condition1.signal();
                try {
                    condition2.await();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
            condition1.signal();
            lock.unlock();
        }
    }
    
}
