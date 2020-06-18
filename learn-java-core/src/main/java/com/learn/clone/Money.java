package com.learn.clone;

import lombok.Data;

/**
 * @author: yeguxin
 * @date: 2020/4/15
 * @description:
 */
@Data
public class Money implements Cloneable {
    private int faceValue;
    
    private Area area;
    
    public Money(int faceValue, Area area) {
        this.faceValue = faceValue;
        this.area = area;
    }
    
    @Override
    protected Money clone() throws CloneNotSupportedException {
        Money cloneMoney = (Money) super.clone();
        // 增加Area的拷贝
        cloneMoney.area = this.area.clone();
        return cloneMoney;
    }
    
    @Override
    public String toString() {
        return "Money{" +
            "faceValue=" + faceValue +
            ", area=" + area +
            '}';
    }
}
