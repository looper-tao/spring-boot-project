package com.learn.base.linkList;

/**
 * @author: yeguxin
 * @date: 2019/12/24
 * @description: 合并两个有序链表
 */
public class MergeLink {
    public static void main(String[] args) {
        HeroNode node1 = buildLinkA();
        HeroNode node2 = buildLinkB();
        HeroNode node = mergeLink(node1, node2);
        System.out.println("-----------------");
        printNode(node);
    }
    
    
    public static HeroNode buildLinkA() {
        HeroNode header = new HeroNode(1, "测试1", "测试1");
        HeroNode node = header;
        for(int i = 3; i <= 18; ) {
            HeroNode temp = new HeroNode(i, "测试" + i, "测试" + i);
            node.setNext(temp);
            node = temp;
            i = i + 2;
        }
        
        return header;
    }
    
    public static HeroNode buildLinkB() {
        HeroNode header = new HeroNode(2, "测试2", "测试2");
        HeroNode node = header;
        for(int i = 4; i <= 10; ) {
            HeroNode temp = new HeroNode(i, "测试" + i, "测试" + i);
            node.setNext(temp);
            node = temp;
            i = i + 2;
        }
        
        return header;
    }
    
    public static void printNode(HeroNode node) {
        while(node != null) {
            System.out.println(node.toString());
            node = node.getNext();
        }
    }
    
    /**
     * 合并两个有序链表
     * @param node1
     * @param node2
     * @return
     */
    public static HeroNode mergeLink(HeroNode node1, HeroNode node2) {
        HeroNode node = null,headerNode = null;
        while(node1 != null || node2 != null) {
            if(node1 == null) {
                if(node == null) {
                    node = node2;
                    headerNode = node;
                }else {
                    node.setNext(node2);
                }
                return headerNode;
                
            }else if(node2 == null) {
                if(node == null) {
                    node = node1;
                    headerNode = node;
                }else {
                    node.setNext(node1);
                }
                return headerNode;
            }
            if(node1 != null && node2 != null && node1.num > node2.num) {
                if(node == null) {
                    node = node2;
                    headerNode = node;
                }else {
                    node.setNext(node2);
                    node = node2;
                }
                node2 = node2.getNext();
                
            }else if(node1 != null && node2 != null && node1.num <= node2.num) {
                if(node == null) {
                    node = node1;
                    headerNode = node;
                }else {
                    node.setNext(node1);
                    node = node1;
                }
                node1 = node1.getNext();
                
            }
        }
        return headerNode;
    }
    
    
}
