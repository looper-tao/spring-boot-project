package com.learn.base;

/**
 * @author: yeguxin
 * @date: 2021/3/19
 * @description: break关键字的作用
 */
public class BreakKeyWordBase {
    private static int count = 0;
    
    public static void main(String[] args) {
        // 简单实用
        method2();
        
        
    }
    
    
    /**
     * 常规使用1
     */
    private static void method1() {
        count = 0;
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 5; j++) {
                count++;
                if(count == 3) {
                    break;
                }
                System.out.println(count);
            }
        }
    }
    
    /**
     * 常规使用2
     */
    private static void method2() {
        count = 0;
        isBreak:
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 5; j++) {
                count++;
                if(count == 3) {
                    break isBreak;
                }
                System.out.println(count);
            }
        }
    }
}
