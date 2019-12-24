package com.learn.base;

import com.learn.lock.ReenterLock;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yeguxin
 * @date: 2019/12/20
 * @description:
 */
public class VolatileBase implements Runnable {
    private static Integer a = 0;
    private static volatile Integer b = 0;
    private static Integer c = 0;
    
//    private static ExecutorService executorService = Executors.newFixedThreadPool()
    private static ExecutorService executor = new ThreadPoolExecutor(100, 1000, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue(10));
    
    private static ReentrantLock lock = new ReentrantLock();
    
    @Override
    public void run() {
//        lock.lock();
        try {
            b++;
            a++;
            synchronized(VolatileBase.class){
                c = c + 1;
            }
//            Thread.sleep(100);
            if(!a.equals(b)) {
                System.out.println("----------------------     a = " + a + "   b = " + b+"c = "+c);
            }
        } finally {
//            lock.unlock();
        }
    }
    
    public static void main(String[] args) {
        for(int i = 0; i < 1000; i++) {
            executor.execute(new VolatileBase());
        }
        while(!c.equals(1000)) {
        
        }
        System.out.println("结束!");
        System.out.println("a = "+a + "    b = "+b + "    c = "+c);
    }
}
