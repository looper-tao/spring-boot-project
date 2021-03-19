package com.learn.thread.threadLocal;

import com.learn.thread.threadLocal.model.ThreadLocalModel1;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * @author: yeguxin
 * @date: 2021/3/8
 * @description:
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        ThreadLocalModel1 threadLocalModel1 = new ThreadLocalModel1();
        WeakReference wef = new WeakReference(threadLocalModel1);

        System.out.println(wef.get());

        System.gc();

        try {
            Thread.sleep(1000L);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        
        // 当强引用(threadLocalModel1)被回收掉了,这个时候弱引用在进行一次GC时就会被回收,不管是否内存够不够
        System.out.println(wef.get());
    
        threadLocalModel1 = null;
        System.gc();
    
        try {
            Thread.sleep(1000L);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    
        // 弱引用在进行一次GC时就会被回收,不管是否内存够不够
        System.out.println(wef.get());
//        WeakReferenceDemo weakReferenceDemo = new WeakReferenceDemo();
//        weakReferenceDemo.m();
    }
    
    public void m(){
        WeakHashMap<Object,String> map = new WeakHashMap<>();
        ThreadLocalModel1 tlm1 = new ThreadLocalModel1();
        ThreadLocalModel1 tlm2 = new ThreadLocalModel1();
        ThreadLocalModel1 tlm3 = new ThreadLocalModel1();
        ThreadLocalModel1 tlm4 = new ThreadLocalModel1();
        ThreadLocalModel1 tlm5 = new ThreadLocalModel1();
        map.put(tlm1,"2");
        map.put(tlm2,"3");
        map.put(tlm3,"4");
        map.put(tlm4,"5");
        map.put(tlm5,"6");
        
        System.out.println(map.isEmpty() +"    "+map.size());
        
        System.gc();
    
        try {
            Thread.sleep(2000L);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(map.isEmpty() +"    "+map.size());
    
        tlm1 = null;
        tlm2 = null;
        
        System.gc();
    
        try {
            Thread.sleep(2000L);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(map.isEmpty() +"    "+map.size());
    }
}
