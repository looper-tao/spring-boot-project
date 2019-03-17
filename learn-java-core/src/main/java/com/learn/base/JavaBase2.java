package com.learn.base;

public class JavaBase2 {
    private static Object object = new Object();
    
    public static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized(object) {
                System.out.println(System.currentTimeMillis() + "    Thread1 start !!!");
                try {
                    Thread.sleep(2000);
                    System.out.println(System.currentTimeMillis() + "    Thread1 wait for object !!!");
                    object.wait();
                    Thread.sleep(2000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                
                System.out.println(System.currentTimeMillis() + "    Thread1 end !!!");
            }
        }
    }
    
    public static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized(object) {
                System.out.println(System.currentTimeMillis() + "    Thread2 notify !!!");
                object.notify();
                System.out.println(System.currentTimeMillis() + "    Thread2 end !!!");
    
                try {
                    Thread.sleep(2000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start();
        t2.start();
    }
}
