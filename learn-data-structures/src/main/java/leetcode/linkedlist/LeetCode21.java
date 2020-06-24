package leetcode.linkedlist;

import nowcoder.Link.ListNode;

/**
 * @author: yeguxin
 * @date: 2020/6/24
 * @description:
 *
 * 21. 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 */
public class LeetCode21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            if(l1 != null){
                return l1;
            }else if(l2 != null){
                return l2;
            }
            return null;
        }
        ListNode head = null;
        ListNode node = new ListNode();
        ListNode pre = null;
        
        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                node.val = l2.val;
                l2 = l2.next;
            }else {
                node.val = l1.val;
                l1 = l1.next;
            }
            node.next = new ListNode();
            if(pre != null) {
                pre.next = node;
            }else {
                head = node;
            }
            pre = node;
            node = node.next;
        }
        if(l1 == null){
            pre.next = l2;
        }else {
            pre.next = l1;
        }
        return head;
    }
    
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(4, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
    
        ListNode node10 = new ListNode(10, null);
        ListNode node9 = new ListNode(9, node10);
        ListNode node8 = new ListNode(4, node9);
        ListNode node7 = new ListNode(3, node8);
        ListNode node6 = new ListNode(1, node7);
    
        ListNode listNode = mergeTwoLists(node1, null);
        
        while(listNode !=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
