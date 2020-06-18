package com.learn.thread.threadPool;

import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author: yeguxin
 * @date: 2020/6/18
 * @description:
 */
public class MyFixedThreadPool {
    
    public static void main(String[] args) {
        ExecutorService threadPool1 = newFixedThreadPool1(3);
        
        for(int i = 0; i < 10; i++) {
            threadPool1.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " is running ..");
                    try {
                        Thread.sleep(2000L);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    
    /**
     * 方式1
     *
     * @param nThreads
     * @return
     */
    public static ExecutorService newFixedThreadPool1(int nThreads) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNamePrefix("demo-pool-").build();
        return new ThreadPoolExecutor(nThreads, nThreads,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(), threadFactory);
    }
    
    /**
     * 方式2
     *
     * @param nThreads
     * @return
     */
    public static ExecutorService newFixedThreadPool2(int nThreads) {
        return Executors.newFixedThreadPool(nThreads);
    }
    
    
}
