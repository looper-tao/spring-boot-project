package com.learn.base;

import org.apache.catalina.Lifecycle;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

/**
 * @Author: taozhengzhi
 * @Date: 2019/6/19 下午5:05
 * @Version 1.0
 */
public class BigDecimalBase {
    private static MathContext mc = new MathContext(8, RoundingMode.HALF_DOWN);
    /**
     * 取余操作
     * @param a
     * @param b
     */
    public static void divideAndRemainderTest(BigDecimal a, BigDecimal b){
//        BigDecimal bigDecimals = a.divideAndRemainder(b)[0];
//
//        // a.divideAndRemainder(b)[0] 商
//        // a.divideAndRemainder(b)[1] 余数
//        System.out.println(a.divideAndRemainder(b)[1].compareTo(BigDecimal.valueOf(0)) == 0);
//    }
//    public static void main(String[] args) {
////        BigDecimalBase.divideAndRemainderTest(BigDecimal.valueOf(10000),BigDecimal.valueOf(10000));
//        BigDecimal a = BigDecimal.valueOf(387);
//        BigDecimal b = BigDecimal.valueOf(365);
//        BigDecimal c = BigDecimal.valueOf(300);
//
////        BigDecimal result = a.multiply(b).setScale(2, BigDecimal.ROUND_HALF_UP);
//        BigDecimal result = a.divide(b, 10, BigDecimal.ROUND_HALF_UP).multiply(b).setScale(2,BigDecimal.ROUND_HALF_UP);
//        BigDecimal setScale = result.multiply(c).setScale(2, BigDecimal.ROUND_HALF_UP);
//        System.out.println("result = "+result);
//        System.out.println("setScale = "+setScale);
//
//        BigDecimal price = BigDecimal.valueOf(387);
//        BigDecimal count = BigDecimal.valueOf(365);
//        price.multiply((count.divide(new BigDecimal(365),10,BigDecimal.ROUND_HALF_DOWN).setScale(10,BigDecimal.ROUND_HALF_DOWN)).setScale(2,BigDecimal.ROUND_HALF_DOWN))
    
    
        
    }
    
}
