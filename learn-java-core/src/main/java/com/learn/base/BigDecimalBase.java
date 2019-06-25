package com.learn.base;

import java.math.BigDecimal;

/**
 * @Author: taozhengzhi
 * @Date: 2019/6/19 下午5:05
 * @Version 1.0
 */
public class BigDecimalBase {
    
    /**
     * 取余操作
     * @param a
     * @param b
     */
    public static void divideAndRemainderTest(BigDecimal a, BigDecimal b){
        BigDecimal bigDecimals = a.divideAndRemainder(b)[0];
        
        // a.divideAndRemainder(b)[0] 商
        // a.divideAndRemainder(b)[1] 余数
        System.out.println(a.divideAndRemainder(b)[1].compareTo(BigDecimal.valueOf(0)) == 0);
    }
    public static void main(String[] args) {
        BigDecimalBase.divideAndRemainderTest(BigDecimal.valueOf(10000),BigDecimal.valueOf(10000));
    }
}
