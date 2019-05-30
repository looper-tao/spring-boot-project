package com.learn.lock;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author: taozhengzhi
 * @Date: 2019/5/15 上午11:56
 * @Version 1.0
 */
public class CyclicBarrierDemo {
    public static class Soldier implements Runnable {
        private String soldier;
        private final CyclicBarrier cyclicBarrier;
        
        public Soldier(String soldier, CyclicBarrier cyclicBarrier) {
            this.soldier = soldier;
            this.cyclicBarrier = cyclicBarrier;
        }
        
        @Override
        public void run() {
            try {
                cyclicBarrier.await();
                doWork();
                cyclicBarrier.await();
            } catch(InterruptedException e) {
                e.printStackTrace();
            } catch(BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
        
        public void doWork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 10000));
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.println(soldier + " :任务执行完成!!!");
        }
    }
    
    public static class BarrierRun implements Runnable {
        private boolean flag;
        private int n;
        
        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            this.n = n;
        }
        
        @Override
        public void run() {
            if(flag) {
                System.out.println("司令: [士兵" + n + "个,任务完成]");
            }else {
                System.out.println("司令: [士兵" + n + "个,集合完毕]");
                flag = true;
            }
        }
    }
    
    
    public static void main(String[] args) {
        final int n = 10;
        boolean flag = false;
        ThreadFactory cyclicBarrierThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-cyclic-barrier-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), cyclicBarrierThreadFactory);
        
        CyclicBarrier cyclic = new CyclicBarrier(n, new BarrierRun(flag, n));
        
        System.out.println("开始集合队伍!!!");
        
        for(int i = 1; i <= 10; i++) {
            System.out.println("士兵" + i + "报道!!!");
            threadPoolExecutor.submit(new Soldier("士兵" + i, cyclic));

        }
        
    }
    
}
