package com.learn.jvm.chapter8;

import java.util.Random;

/**
 * @author: yeguxin
 * @date: 2019/11/22
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        System.gc();
        
        
    }
    
    
}
