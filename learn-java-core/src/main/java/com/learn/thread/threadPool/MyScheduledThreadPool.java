package com.learn.thread.threadPool;

import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author: yeguxin
 * @date: 2020/6/18
 * @description:
 */
public class MyScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool1 = newScheduledThreadPool1(3);
        
        for(int i=0;i<10;i++){
            // 延时执行
            scheduledThreadPool1.schedule(new Runnable() {
        
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " is running ..");
//                    System.out.println("delay 3 seconds");
                }
            }, 3, TimeUnit.SECONDS);
        }
        

    }
    
    /**
     * 方式1
     * @param corePoolSize
     * @return
     */
    public static ScheduledExecutorService newScheduledThreadPool1(int corePoolSize) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNamePrefix("demo-pool-").build();
        return new ScheduledThreadPoolExecutor(corePoolSize, threadFactory);
    }
    
    /**
     * 方式2
     * @param corePoolSize
     * @return
     */
    public static ScheduledExecutorService newScheduledThreadPool2(int corePoolSize) {
        return Executors.newScheduledThreadPool(corePoolSize);
    }
    
}
