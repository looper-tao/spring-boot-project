package com.learn.thread;

/**
 * @author: yeguxin
 * @date: 2020/6/17
 * @description:
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
        // 业务逻辑
        System.out.println("MyThread.run()");
    }
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
    }
}
