package com.learn.thread.threadPool;

import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author: yeguxin
 * @date: 2020/6/18
 * @description:
 */
public class MyCachedThreadPool {
    public static void main(String[] args) {
        
        // 方式1
        ExecutorService cachedThreadPool1 = newCachedThreadPool1();
        for(int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000L);
            }catch(Exception e){
                e.printStackTrace();
            }
            cachedThreadPool1.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " is running ..");
                }
            });
        }
        
    }
    
    /**
     * 方式1
     *
     * @return
     */
    public static ExecutorService newCachedThreadPool1() {
        ThreadFactory namedThreadFactory = (new ThreadFactoryBuilder()).setNamePrefix("demo-pool-").build();
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
            60L, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>(), namedThreadFactory);
    }
    
    /**
     * 方式2
     *
     * @return
     */
    public static ExecutorService newCachedThreadPool2() {
        return Executors.newCachedThreadPool();
    }
    
}
