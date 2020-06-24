package lock;

import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 倒计数器
 *
 * @Author: taozhengzhi
 * @Date: 2019/4/2 下午5:44
 * @Version 1.0
 */
public class CountDownLatchDemo implements Runnable {
    /**
     * CountDownLatch可以让某一个线程等待知道倒计数结束,在开始执行
     * 下面的计数数量为10 说明需要10个线程完成任务后等待在countDownLatch上的线程才能继续执行
     */
    static final CountDownLatch end = new CountDownLatch(10);
    
    static final CountDownLatchDemo demo = new CountDownLatchDemo();
    
    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println("check complete!");
            //通知countDownLatch,一个线程已经完成了任务,倒计数器减1
            end.countDown();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        /**
         * 典型场景: 火箭发射
         * 在火箭发射前,为了保证万无一失,往往还要对各项设备,仪器进行检查.
         * 只有等所有检查前部完成后,在执行点火操作.
         */
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().build();//.setNameFormat("thread-count-down-latch-runner-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), namedThreadFactory);
        
        for(int i = 0; i < 10; i++) {
            executorService.submit(demo);
        }
        //要求主线程等待所有检查任务全部完成(10个任务全部完成后),主线程才能继续执行
        end.await();
        System.out.println("Fire!");
        executorService.shutdown();
        
    }
}
