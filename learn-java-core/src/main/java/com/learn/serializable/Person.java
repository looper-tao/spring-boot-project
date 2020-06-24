package com.learn.serializable;

import java.io.Serializable;

/**
 * @author: yeguxin
 * @date: 2020/6/22
 * @description:
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int age;
    
    public Person() {
        System.out.println("无参构造函数");
    }
    
    public Person(String name, int age) {
        System.out.println("有参构造函数");
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}
