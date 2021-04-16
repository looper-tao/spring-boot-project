package com.learn.base;

import com.learn.base.linkList.HeroNode;
import lombok.Data;

import java.util.*;

/**
 * @author: yeguxin
 * @date: 2019/10/21
 * @description:
 */
public class LinkListBase {
//    public static void main(String[] args) {
//
//        HeroNode head = new HeroNode(0,"","");
//        HeroNode node1 = new HeroNode(1,"宋江","呼保义");
//        head.setNext(node1);
//        HeroNode node2 = new HeroNode(2,"卢俊义","玉麒麟");
//        node1.setNext(node2);
//        HeroNode node3 = new HeroNode(3,"无用","智多星");
//        node2.setNext(node3);
//        HeroNode node4 = new HeroNode(4,"公孙胜","入云龙");
//        node3.setNext(node4);
//
//        HeroNode node = head.getNext();
//        while(node!=null){
//            System.out.println(node.toString());
//            node = node.getNext();
//        }
//
//
//        HeroNode cur = head.getNext();
//        HeroNode next = null;
//        HeroNode reverseHead = new HeroNode(0,"","");
//
//        while(cur != null){
//            next = cur.getNext();
//            cur.setNext(reverseHead.getNext());
//            cur = next;
//        }
//
//        head.setNext(reverseHead.getNext());
//
//        System.out.println("-----------------------------------------------");
//        node = head.getNext();
//        while(node!=null){
//            System.out.println(node.toString());
//            node = node.getNext();
//        }
//
//
//
//    }
    
    public static void main(String[] args) {
        for(int i =1;i<100;i++){
    
            int result = LinkListBase.tableSizeFor(129);
            System.out.println(i+"      "+result);
        }
        
    }
    
    private static int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : n + 1;
    }
}
