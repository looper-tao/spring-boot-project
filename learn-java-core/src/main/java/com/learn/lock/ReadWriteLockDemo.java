package lock;


import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * @Author: taozhengzhi
 * @Date: 2019/4/2 下午4:03
 * @Version 1.0
 */
public class ReadWriteLockDemo {
    private static Lock lock = new ReentrantLock();
    
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    
    private static Lock readLock = readWriteLock.readLock();
    
    private static Lock writeLock = readWriteLock.writeLock();
    
    private int value;
    
    public Object handleRead(Lock lock) {
        try {
            lock.lock();
            //模拟读操作
            System.out.println(Thread.currentThread().getName() + "正在进行读操作!!!");
            Thread.sleep(1000L);
            return value;
        } catch(InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return value;
    }
    
    public void handleWrite(Lock lock, int index) {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "正在进行写操作!!!");
            Thread.sleep(1000L);
            value = index;
        } catch(InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    
    public static void main(String[] args) {
        final ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
        
        Runnable readRunnale = new Runnable() {
            
            @Override
            public void run() {
//                readWriteLockDemo.handleRead(readLock);
                readWriteLockDemo.handleRead(lock);
            }
        };
        
        Runnable writeRunnable = new Runnable() {
            
            @Override
            public void run() {
//                readWriteLockDemo.handleWrite(writeLock, new Random().nextInt());
                readWriteLockDemo.handleWrite(lock, new Random().nextInt());
            }
        };
        
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().build();//.setNameFormat("thread-read-write-runner-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(40, 40, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), namedThreadFactory);
       
        for(int i = 0; i < 20; i++) {
            executorService.submit(readRunnale);
        }
        for(int i = 0; i < 20; i++) {
            executorService.submit(writeRunnable);
        }
    }
}
