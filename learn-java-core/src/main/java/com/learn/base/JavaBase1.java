package com.learn.base;

/**
 * 共同指向同一个对象的内存地址
 */
public class JavaBase1 {
    public static void main(String[] args) {
        Student xiaoming = new Student("小明",18,99);
        Student xiaohua = xiaoming;
        
        xiaohua.setAge(19);
        xiaohua.setName("小华");
        System.out.println("小华 : "+xiaohua.toString());
        System.out.println("小明 : "+xiaoming.toString());
    }
}


class Student {
    String name;
    Integer age;
    Integer score;
    
    public Student(String name, Integer age, Integer score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Integer getScore() {
        return score;
    }
    
    public void setScore(Integer score) {
        this.score = score;
    }
    
    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", score=" + score +
            '}';
    }
}