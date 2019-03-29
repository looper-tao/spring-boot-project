package com.learn.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 * @Author: ye
 * @Date: 2019/3/29 上午10:02
 * @Version 1.0
 */
public class ReenterLock implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();
    private static int count = 0;
    
    @Override
    public void run() {
        for(int i = 0; i < 10000000; i++) {
            lock.lock();
            try {
                
                count++;
            } finally {
                lock.unlock();
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        ReenterLock reenterLock = new ReenterLock();
        Thread thread1 = new Thread(reenterLock);
        Thread thread2 = new Thread(reenterLock);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("count = " + count);
    }
}
