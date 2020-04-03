package com.learn.pattern.singleton;

/**
 * 单例模式
 * @author: yeguxin
 * @date: 2020/4/3
 * @description:
 */
public class Singleton {
    //私有的静态变量
    private static Singleton instance;
    
    /**
     * 私有的构造方法
     */
    private Singleton() {
    }
    
    /**
     * 1. 懒汉式
     *
     * @return .
     */
    public static synchronized Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    
    // ------------------------------------------------------------------------
    
    private static final Singleton INSTANCE2 = new Singleton();
    
    /**
     * 2.饿汉式
     *
     * @return
     */
    public static Singleton getInstance2() {
        return INSTANCE2;
    }
    
    // ------------------------------------------------------------------------
    
    
    /**
     * 3.DCL双重校验模式
     *
     * @return .
     */
    public static Singleton getInstance3() {
        //第一层校验
        if(instance == null) {
            synchronized(Singleton.class) {
                //第二层校验
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    
    // ------------------------------------------------------------------------
    
    /**
     * 4.静态内部类单例模式
     *
     * @return .
     */
    public static final Singleton getInstance4() {
        return SingletonHolder.INSTANCE;
    }
    
    /**
     * 定义的静态内部类
     */
    private static class SingletonHolder {
        //创建实例的地方
        private static final Singleton INSTANCE = new Singleton();
    }
    
    // ------------------------------------------------------------------------
    
    private enum EnumSingleton {
        /**
         * 枚举
         */
        INSTANCE;
        
        /**
         * 单例对象
         */
        private final Singleton instance;
        
        EnumSingleton() {
            instance = new Singleton();
        }
        
        private Singleton getInstance() {
            return instance;
        }
    }
    
    /**
     * 5.枚举单例
     *
     * @return .
     */
    public static Singleton getInstance5() {
        return EnumSingleton.INSTANCE.getInstance();
    }
    
    // ------------------------------------------------------------------------
    
}
