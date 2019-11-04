package com.learn.base.linkList;

/**
 * @author: yeguxin
 * @date: 2019/10/21
 * @description:
 */
public class HeroNode {
    int num;
    String name;
    String nickName;
    HeroNode next;
    
    public HeroNode(int num,String name,String nickName,HeroNode next){
        this.num = num;
        this.name = name;
        this.nickName = nickName;
        this.next = next;
    }
    
    public HeroNode(int num,String name,String nickName){
        this.num = num;
        this.name = name;
        this.nickName = nickName;
        this.next = next;
    }
    
    @Override
    public String toString() {
        return "HeroNode{" +
            "num=" + num +
            ", name='" + name + '\'' +
            ", nickName='" + nickName + '\'' +
            '}';
    }
    
    public int getNum() {
        return num;
    }
    
    public void setNum(int num) {
        this.num = num;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getNickName() {
        return nickName;
    }
    
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    public HeroNode getNext() {
        return next;
    }
    
    public void setNext(HeroNode next) {
        this.next = next;
    }
}
