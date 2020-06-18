package com.learn.thread;

/**
 * @author: yeguxin
 * @date: 2020/6/17
 * @description:
 */
public class MyThread2 implements Runnable {
    @Override
    public void run() {
        // 业务逻辑
        System.out.println("MyThread2.run()");
    }
    
    public static void main(String[] args) {
        //启动 MyThread，需要首先实例化一个 Thread，并传入自己的 MyThread 实例:
        MyThread2 myThread = new MyThread2();
        Thread thread = new Thread(myThread);
        thread.start();
    }
}
