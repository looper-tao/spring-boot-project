package leetcode.linkedlist;

import nowcoder.Link.ListNode;

/**
 * @author: yeguxin
 * @date: 2020/6/29
 * @description:
 *
 * 25. K 个一组翻转链表
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *  
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 */
public class LeetCode25 {
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode node = head;
        for(int i = 1; i < k; i++) {
            node = node.next;
            if(node == null){
                return head;
            }
        }
    
        ListNode tempNode = reverseKGroup(node.next, k);
        ListNode reverse = reverse(head, node,tempNode);
        return reverse;
    }
    
    public ListNode reverse(ListNode head,ListNode tail,ListNode tempNode){
        ListNode preNode = tempNode;
        while(head != tail && head != null){
            ListNode nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }
        
        head.next = preNode;;
        return head;
    }
    
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        
        LeetCode25 leetCode25 = new LeetCode25();
        ListNode node = leetCode25.reverseKGroup(node1, 5);
        while(node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
