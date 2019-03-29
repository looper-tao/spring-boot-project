package com.learn.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁
 * @Author: ye
 * @Date: 2019/3/29 下午5:48
 * @Version 1.0
 */
public class FairLock implements Runnable {
    private static ReentrantLock lock = new ReentrantLock(true);
    
    @Override
    public void run() {
        while(true){
            try{
                //获得锁,如果锁已经被占用,则等待
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"获得了锁!!!");
    
            }finally {
                lock.unlock();
            }
        }
    }
    
    
    public static void main(String[] args) {
        //预期是3个线程是交替获得锁的,几乎不会同一线程连续多次获得锁的可能.从而保证了公平性.
        FairLock fairLock = new FairLock();
        
        Thread thread1 = new Thread(fairLock);
        Thread thread2 = new Thread(fairLock);
        Thread thread3 = new Thread(fairLock);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
