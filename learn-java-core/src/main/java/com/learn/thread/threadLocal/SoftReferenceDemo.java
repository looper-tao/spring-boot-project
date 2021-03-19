package com.learn.thread.threadLocal;

import com.learn.thread.threadLocal.model.ThreadLocalModel1;

import java.lang.ref.SoftReference;

/**
 * @author: yeguxin
 * @date: 2021/3/8
 * @description: 软引用
 */
public class SoftReferenceDemo {
    public static void main(String[] args) {
        SoftReference sef = new SoftReference<>(new ThreadLocalModel1());
        
        System.out.println(sef.get());
        // 建议进行垃圾回收
        System.gc();
    
        try {
            Thread.sleep(1000L);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sef.get());
        
        // 当JVM 进行GC时 软引用如果再用不会主动被清除掉
        // 但是如果堆中的内存不够了,GC时会先将软引用清除掉
        Byte[] bytes = new Byte[1024 * 1024 * 15];
        System.out.println(sef.get());
        
    }
}
