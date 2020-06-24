package com.learn.nested;

/**
 * @author: yeguxin
 * @date: 2020/6/22
 * @description: 匿名内部类
 * <p>
 * 匿名内部类我们必须要继承一个父类或者实现一个接口，当然也仅能只继承一个父类或者实现一个接口。
 * 同时它也是没有 class 关键字，这是因为匿名内部类是直接使用 new 来生成一个对象的引用。
 */
abstract class Bird {
    private String name;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public abstract int fly();
}

public class AnonymousNestedClass {
    public void test(Bird bird) {
        System.out.println(bird.getName() + "能够飞 " + bird.fly() + "米");
    }
    
    public static void main(String[] args) {
        AnonymousNestedClass test = new AnonymousNestedClass();
        test.test(new Bird() {
            public int fly() {
                return 10000;
            }
            
            public String getName() {
                return "大雁";
            }
        });
        
        
    }
}

