package com.learn.base;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Random;

/**
 * @author: yeguxin
 * @date: 2020/4/15
 * @description:
 */
public class RandomDemo {
    private Boolean a;
    
    public static void main(String[] args) {
//        MathContext mc = new MathContext(5, RoundingMode.HALF_DOWN);
//        BigDecimal initialPremium = new BigDecimal("26.7", mc);
//        System.out.println(initialPremium);
        
        for(int i = 0; i < 100; i++) {
            
            int random = (new Random()).nextInt(10);
            System.out.println(random);
        }
        
    }
}
