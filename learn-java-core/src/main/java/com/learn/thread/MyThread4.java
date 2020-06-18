package com.learn.thread;

import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author: yeguxin
 * @date: 2020/6/17
 * @description:
 */
public class MyThread4 {
    public static void main(String[] args) {
//        // 创建线程池
//        ExecutorService threadPool = Executors.newFixedThreadPool(10);
//        int i = 0;
//        while(i < 20) {
//            threadPool.execute(new Runnable() {
//                // 提交多个线程任务，并执行
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName() + " is running ..");
//                    try {
//                        Thread.sleep(100);
//                    } catch(InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//            i++;
//        }
//
        
        ThreadFactory namedThreadFactory = (new ThreadFactoryBuilder()).setNamePrefix("demo-pool-").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 15, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), namedThreadFactory);
        for(int j=0;j<20;j++){
            threadPoolExecutor.execute(new Runnable() {
                // 提交多个线程任务，并执行
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " is running ..");
                    try {
                        Thread.sleep(200);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    
}