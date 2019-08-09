package com.learn.base;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: taozhengzhi
 * @Date: 2019/8/8 下午1:59
 * @Version 1.0
 */
public class JavaLangReflectTypeBase {
    public static void main(String[] args) {
        Map<Type,String> typeMap = new HashMap<>();
        
        typeMap.put(String.class,"String类型");
        typeMap.put(Integer.class,"Integer类型");
        typeMap.put(Long.class,"Long类型");
        typeMap.put(BigDecimal.class,"BigDecimal类型");
       
        System.out.println(typeMap.get("123".getClass()));
    }
}
