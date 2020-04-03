package com.learn.pattern.factory.abstract_factory_pattern;

/**
 * 英菲尼迪工厂 (具体工厂角色)
 * @author: yeguxin
 * @date: 2020/4/3
 * @description:
 */
public class InfinitiFactory extends AbstractFactory {
    @Override
    Car getCar() {
        return new InfinitiCar();
    }
    
    @Override
    DVR getDVR() {
        return new InfinitiDVR();
    }
}