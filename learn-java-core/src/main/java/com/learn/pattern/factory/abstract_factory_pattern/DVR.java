package com.learn.pattern.factory.abstract_factory_pattern;

/**
 * 行车记录仪父类   (抽象产品角色)
 *
 * @author: yeguxin
 * @date: 2020/4/3
 * @description:
 */
public abstract class DVR {
    String name;
    void printDVR(){
        System.out.println(name+"行车记录仪已制造完成");
    }
}