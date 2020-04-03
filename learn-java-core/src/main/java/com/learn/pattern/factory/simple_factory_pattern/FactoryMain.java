package com.learn.pattern.factory.simple_factory_pattern;

/**
 * @author: yeguxin
 * @date: 2020/4/2
 * @description:
 */
public class FactoryMain {
    public static void main(String[] args) {
        
        Person person = SayFactory.getSay("man");
        
        System.out.println(person.say());
    }
}
