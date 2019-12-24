package com.learn.base.linkList;

/**
 * @author: yeguxin
 * @date: 2019/12/23
 * @description: 链表反转
 */
public class ReverseLink {
    public static void main(String[] args) {
        HeroNode node = buildLike();
        printNode(node);
        System.out.println("------------");
        printNode(reverseLink(node));
    }
    
    public static HeroNode buildLike() {
        HeroNode header = new HeroNode(1, "测试1", "测试1");
        HeroNode node = header;
        for(int i = 2; i <= 10; i++) {
            HeroNode temp = new HeroNode(i, "测试" + i, "测试" + i);
            node.setNext(temp);
            node = temp;
            
        }
        
        return header;
    }
    
    public static void printNode(HeroNode node) {
        while(node != null) {
            System.out.println(node.toString());
            node = node.getNext();
        }
    }
    
    public static HeroNode reverseLink(HeroNode node){
        
        HeroNode pre = null;
        while(node !=null){
            HeroNode next = node.getNext();
            node.setNext(pre);
            pre = node;
            node = next;
        }
        return pre;
    }
}
