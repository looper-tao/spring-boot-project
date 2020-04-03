package com.learn.pattern.factory.abstract_factory_pattern;

/**
 *
 * 抽象工厂模式
 * @author: yeguxin
 * @date: 2020/4/3
 * @description:
 */
public class AbstractFactoryPatternMain {
    public static void main(String[] args) {
        AbstractFactory factory = new NissanFactory();
        Car car = factory.getCar();
        car.printCar();
        DVR dvr = factory.getDVR();
        dvr.printDVR();
    }
}
