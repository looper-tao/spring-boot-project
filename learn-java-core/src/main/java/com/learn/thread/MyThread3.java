package com.learn.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: yeguxin
 * @date: 2020/6/17
 * @description:
 */

class MyCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"\t coming in");
        return "success!";
    }
}

public class MyThread3 {
    
    private static final int TASK_SIZE = 10;
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(TASK_SIZE);
        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < TASK_SIZE; i++) {
            Callable c = new MyCallable();
            // 执行任务并获取 Future 对象
            Future f = pool.submit(c);
            list.add(f);
        }
        // 关闭线程池
        pool.shutdown();
        // 获取所有并发任务的运行结果
        for
        (Future f : list) {
            // 从 Future 对象上获取任务的返回值，并输出到控制台
            System.out.println("res:" + f.get().toString());
        }
    }
    
   
}
