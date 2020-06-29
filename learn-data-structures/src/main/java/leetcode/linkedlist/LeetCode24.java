package leetcode.linkedlist;

import nowcoder.Link.ListNode;

/**
 * @author: yeguxin
 * @date: 2020/6/29
 * @description:
 *
 * 24. 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3
 *
 */
public class LeetCode24 {
    
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode node = head;
        ListNode next = head.next;
        
        ListNode temoNode = swapPairs(next.next);
        swap(node, next, temoNode);
        
        return next;
    }
    
    public void swap(ListNode head, ListNode next, ListNode tempNode) {
        next.next = head;
        head.next = tempNode;
    }
    
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        
        LeetCode24 leetCode24 = new LeetCode24();
        ListNode node = leetCode24.swapPairs(node1);
        
        while(node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
    
}
