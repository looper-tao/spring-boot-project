package com.learn.clone;

/**
 * @author: yeguxin
 * @date: 2020/4/15
 * @description:
 */
public class CloneDemo {
    public static void main(String[] args) {
        Area area = new Area();
        area.setUnit("人民币");

        Money money = new Money(100,area);

        try {
            Money moneyClone = money.clone();
            moneyClone.setFaceValue(200);
            area.setUnit("美元");

            System.out.println(money.toString());
            System.out.println(moneyClone.toString());
        } catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
    
       
    }
}
