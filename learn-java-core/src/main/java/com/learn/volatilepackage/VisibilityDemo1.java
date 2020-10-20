package com.learn.volatilepackage;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yeguxin
 * @date: 2020/8/12
 * @description:
 */
public class VisibilityDemo1 implements Runnable {
    public static boolean flag = false;
    static VisibilityDemo1 myThread = new VisibilityDemo1();
    ReentrantLock lock = new ReentrantLock();
    
    
    @Override
    public void run() {
        while(true) {
            lock.lock();
            if(flag) {
                System.out.println("flag = true");
            }
            lock.unlock();
        }
    }
    
    public static void main(String[] args) {
        
        Thread t1 = new Thread(myThread);
        t1.start();
        
        try {
            Thread.sleep(10);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag 被设置为true ");
    }
}
