package com.learn.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yeguxin
 * @date: 2020/8/11
 * @description:
 */
public class AlternatePrintDemo implements Runnable {
    static ReentrantLock reentrantLock = new ReentrantLock(false);
    
    static Condition c1 = reentrantLock.newCondition();
    static Condition c2 = reentrantLock.newCondition();
    static volatile boolean flag = true;
    
    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
            reentrantLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " 正在打印: " + i);
            } finally {
                reentrantLock.unlock();
            }
            
        }
    }
    
    public static void t1Run() {
        for(int i = 0; i < 1000; i++) {
            reentrantLock.lock();
            try {
                String threadName = Thread.currentThread().getName();
                while(!flag) {
                    c1.await();
                }
                System.out.println(threadName + "正在打印: " + i);
                flag = false;
                c2.signal();
                
            } catch(InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
    }
    
    public static void t2Run() {
        for(int i = 0; i < 1000; i++) {
            reentrantLock.lock();
            try {
                String threadName = Thread.currentThread().getName();
                while(flag) {
                    c2.await();
                }
                System.out.println(threadName + "正在打印: " + i);
                flag = true;
                c1.signal();
            } catch(InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
//        AlternatePrintDemo apd = new AlternatePrintDemo();
//
//        Thread t1 = new Thread(apd,"t1");
//        t1.setPriority(10);
//        Thread t2 = new Thread(apd,"t2");
//        t2.setPriority(1);
//
//        t1.start();
//        t2.start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                t1Run();
            }
        }, "t1").start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                t2Run();
            }
        }, "t2").start();
    }
}
