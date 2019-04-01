package com.learn.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition功能
 * @Author: taozhengzhi
 * @Date: 2019/4/1 下午5:46
 * @Version 1.0
 */
public class ReenterLockCondition implements Runnable {
    /**
     * 创建一个可重入锁
     */
    public static ReentrantLock lock = new ReentrantLock();
    
    /**
     * 通过lock生成一个与之绑定的Condition对象
     */
    public static Condition condition = lock.newCondition();
    
    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("线程正在执行!!!");
            //要求线程在Condition对象上进行等待.
            //与Object.wait() 与 notify()方法一样,
            //当线程使用Condition.await()方法时,要求线程持有相关的重入锁
            //当Condition.await()方法调用后,这个线程会释放这把锁.
            condition.await();
            System.out.println("Thread is going on !!!");
        } catch(InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        
    }
    
    public static void main(String[] args) throws InterruptedException {
        ReenterLockCondition reenterLockCondition = new ReenterLockCondition();
        
        Thread thread1 = new Thread(reenterLockCondition);
        thread1.start();
        Thread.sleep(2000L);
        //在调用Condition.signal()方法前,也要求线程先获得这把锁.
        // 在signal()方法调用后.系统会从当前Condition对象的等待队列中唤醒一个线程.
        // 一旦线程被唤醒,他会重新尝试获得与之绑定的重入锁.一旦成功获取就可以继续执行了.
        lock.lock();
        //主线程main发出通知,告知等待在Condition上的线程可以继续执行了.
        condition.signal();
        //在调用Condition.signal()方法后,一般需要释放相关的锁,让给被唤醒的线程.让他可以继续执行
        //如果不加入下面的unlock()方法,那么线程thread1就无法重新获得锁,也就无法真正的继续执行.
        lock.unlock();
    }
}
