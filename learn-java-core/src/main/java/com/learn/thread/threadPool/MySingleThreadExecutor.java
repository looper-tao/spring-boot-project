package com.learn.thread.threadPool;

import java.util.concurrent.*;

/**
 * @author: yeguxin
 * @date: 2020/6/18
 * @description:
 */
public class MySingleThreadExecutor {
    
    public static void main(String[] args) {
        ExecutorService executorService = newSingleThreadExecutor1();
        for(int i=1;i<=5;i++){
            int index=i;
            executorService.execute(new Runnable(){
                @Override
                public void run() {
                    try{
                        System.out.println(Thread.currentThread().getName() + " is running ..");
                        Thread.sleep(2000);
                    }catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                } });
        }
        
    }
    
    
    public static ExecutorService newSingleThreadExecutor1() {
        return Executors.newSingleThreadExecutor();
    }
}
