package com.learn.pattern.factory.simple_factory_pattern;

/**
 * @author: yeguxin
 * @date: 2020/4/2
 * @description:
 */
public class SayFactory {
    public static Person getSay(String sex){
        if("man".equals(sex)){
            return new Man();
        }else if("woman".equals(sex)){
            return new Woman();
        }else{
            System.out.println("请输入正确的性别");
        }
        // 默认为男人
        return new Man();
    }
}
