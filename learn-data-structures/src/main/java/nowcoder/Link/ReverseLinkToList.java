package nowcoder.Link;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: yeguxin
 * @date: 2019/12/26
 * @description:
 */
public class ReverseLinkToList {
    
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        
        while(listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(list);
        return list;
    }
    
//    public static void main(String[] args) {
//        System.out.println(Power(2, -1));
//    }
    
    public static double Power(double base, int exponent) {
        if(exponent == 0) {
            return 1;
        }
        if(exponent == 1) {
            return base;
        }
        boolean flag = false;
        if(exponent < 0) {
            flag = true;
            exponent = -exponent;
        }
        double a = Power(base, exponent >> 1);
        
        a = a * a;
        if(exponent % 2 == 1) {
            a = a * base;
        }
        
        return flag ? 1 / a : a;
    }
    
    
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode node = null;
        ListNode result = head;
        while(head != null) {
            k--;
            if(k <= 0) {
                node = result;
                result = result.next;
            }
            head = head.next;
        }
        return node;
    }
    
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ReverseList(node1);
        
    }
    
    public static ListNode ReverseList(ListNode head) {
        ListNode temp = null;
        ListNode node = null;
        while(head != null) {
            node = head;
            head = head.next;
            node.next = temp;
            temp = node;
        }
        return node;
    }
}
