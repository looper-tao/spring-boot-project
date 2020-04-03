package com.learn.pattern.factory.abstract_factory_pattern;

/**
 * 日产工厂 (具体工厂角色)
 * @author: yeguxin
 * @date: 2020/4/3
 * @description:
 */
public class NissanFactory extends AbstractFactory {
    @Override
    Car getCar() {
        return new NissanCar();
    }
    
    @Override
    DVR getDVR() {
        return new NissanDVR();
    }
}