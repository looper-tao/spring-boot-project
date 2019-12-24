package lock;

import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 信号量
 * @Author: taozhengzhi
 * @Date: 2019/4/2 下午2:24
 * @Version 1.0
 */
public class SemapDemo implements Runnable {
    /**
     * 声明一个包含5个许可的信号量(这就意味着同时可以有5个线程进入临界区代码)
     */
    final Semaphore semaphore = new Semaphore(5);
    
    @Override
    public void run() {
        try {
            //程序会限制执行这段代码的线程数,
            semaphore.acquire();
            Thread.sleep(2000L);
            System.out.println(Thread.currentThread().getName() + "  done !!!");
        } catch(InterruptedException e) {
            e.printStackTrace();
        } finally {
            //离开时务必使用release()方法释放信号量.
            semaphore.release();
        }
    }
    
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().build();
        ExecutorService executorService = new ThreadPoolExecutor(20, 20, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), namedThreadFactory);
        
        final SemapDemo demo = new SemapDemo();
        for(int i = 0; i < 20; i++) {
            executorService.submit(demo);
        }
        
    }
    
}
