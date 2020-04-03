package com.learn.pattern.factory.abstract_factory_pattern;

/**
 * 工厂父类 (抽象工厂角色)
 * @author: yeguxin
 * @date: 2020/4/3
 * @description:
 */
public abstract class AbstractFactory {
    abstract Car getCar();
    abstract DVR getDVR();
}