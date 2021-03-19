package com.learn.thread.threadLocal;

import com.learn.thread.threadLocal.model.ThreadLocalModel1;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: yeguxin
 * @date: 2021/3/8
 * @description:
 */
public class PhantomReferenceDemo {
    private static List<Object> list = new LinkedList<>();
    
    private static ReferenceQueue<ThreadLocalModel1> queue = new ReferenceQueue<>();
    
    public static void main(String[] args) {
        PhantomReference phantomReference = new PhantomReference(new ThreadLocalModel1(), queue);
    
        // 虚引用创建出来再次获取就为null.
        // 弱引用主要的使用场景是在于:跟踪对象的生命周期.
        // 在上面的代码中的 new ThreadLocalModel1() 被JVM回收掉时会进入queue队列中. 至于new ThreadLocalModel1()的对象什么时候被回收掉由JVM决定
        // 例如一个常见的功能就是: NIO中 存储在直接内存中的数据什么时候会被操作系统回收掉呢?
        //  这就使用到了虚引用的特点.当JVM中引用了直接内存的强引用的对象被回收掉了(对应本例子中的ThreadLocalModel1对象).这个时候直接内存中的数据也就没有了作用.
        //  但是JVM是没有权限去直接内存中进行垃圾回收的,所以这时候使用虚引用的特点,进行垃圾回收后会往队列中查询一条数据.可以基于这条数据让操作系统回收该块直接内存的数据
        System.out.println(phantomReference.get());
        
        new Thread(() -> {
            while(true) {
                list.add(new Byte[1024 * 1024]);
                
                try {
                    Thread.sleep(500L);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(phantomReference.get());
            }
        }).start();
        
        new Thread(() -> {
            while(true){
                Reference<? extends ThreadLocalModel1> reference = queue.poll();
                if(reference != null){
                    System.out.println("该引用已被回收");
                }
            }
        }).start();
    }
}
