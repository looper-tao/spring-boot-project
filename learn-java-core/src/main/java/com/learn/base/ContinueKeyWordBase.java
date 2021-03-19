package com.learn.base;

/**
 * @author: yeguxin
 * @date: 2021/3/19
 * @description:
 */
public class ContinueKeyWordBase {
    private static int count = 0;
    
    public static void main(String[] args) {
        // 简单实用
//        method1();
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
                    continue;
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
        isContinue:
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 5; j++) {
                count++;
                if(count == 3) {
                    // 相当于 break
                    continue isContinue;
                }
                System.out.println(count);
            }
        }
    }
}
