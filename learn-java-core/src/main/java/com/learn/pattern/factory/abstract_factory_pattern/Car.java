package com.learn.pattern.factory.abstract_factory_pattern;

/**
 * 汽车的父类 (抽象产品角色)
 * @author: yeguxin
 * @date: 2020/4/3
 * @description:
 */
public abstract class Car {
    String name;
    void printCar(){
        System.out.println(name+"汽车已制造完成");
    }
}