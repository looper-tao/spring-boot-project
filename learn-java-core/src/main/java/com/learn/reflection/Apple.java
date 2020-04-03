package com.learn.reflection;

/**
 * @author: yeguxin
 * @date: 2020/2/6
 * @description:
 */
public class Apple extends Fruit{
    String color;//默认default
    public int size;
    private int price;
    
    Apple() {//默认default
        System.out.println("Apple的无参构造");
    }
    
    public Apple(String color, int size, int price) {
        this.color = color;
        this.size = size;
        this.price = price;
        System.out.println("Apple的有参构造——三个参数");
    }
    
    private Apple(String color, int size) {
        this.color = color;
        this.size = size;
        this.price = 10;
        System.out.println("Apple的有参构造——两个参数");
    }
    
    @Override
    public String toString() {
        return "color:" + color + ",size:" + size + ",price:" + price;
    }
    
    //默认default
    String getColor() {
        return color;
    }
    
    public int getSize() {
        return size;
    }
    
    public int getPrice() {
        return price;
    }
    
    //默认default
    void setColor(String color) {
        this.color = color;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    private void setPrice(int price) {
        this.price = price;
    }
}
