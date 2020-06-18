package com.learn.clone;

import lombok.Data;

/**
 * @author: yeguxin
 * @date: 2020/4/15
 * @description:
 */
@Data
public class Area implements Cloneable{
    // 钞票单位
    private String unit;
    
    @Override
    protected Area clone() throws CloneNotSupportedException {
        return (Area) super.clone();
    }
}
