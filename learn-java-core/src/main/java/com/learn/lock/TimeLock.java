package com.learn.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁申请 等待限时
 * @Author: ye
 * @Date: 2019/3/29 下午4:13
 * @Version 1.0
 */
public class TimeLock implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();
    
    @Override
    public void run() {
        try {
            // 5 : 等待时长
            // TimeUnit.SECONDS :  计时单位
            // 这个线程会在这个锁请求中最多等待5秒,如果超过5秒还没有得到锁,就会返回false.如果成功获得锁,则返回true
            //如果tryLock()方法不带参数运行,在这种情况下,当前线程会尝试获得锁,
            //  如果锁没有被其他线程占用,则申请锁成功,并立即返回true,
            //  如果锁被其他线程占用,则当前线程不会进行等待,而是立即返回false.
            //这种模式不会引起线程等待,因此不会产生死锁.
            if(lock.tryLock(2001, TimeUnit.MILLISECONDS)){
                System.out.println(Thread.currentThread().getName()+"正在运行!");
                //占用可锁之后 sleep10秒,所以另一个线程无法在5秒的时间内获得锁,因此请求锁会失败
                Thread.sleep(1000L);
            }else {
                System.out.println("get lock failed !!!");
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }
    
    public static void main(String[] args) {
        TimeLock timeLock = new TimeLock();
    
        Thread thread1 = new Thread(timeLock);
        Thread thread2 = new Thread(timeLock);
        Thread thread3 = new Thread(timeLock);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
