package leetcode.linkedlist;

import nowcoder.Link.ListNode;

/**
 * @author: yeguxin
 * @date: 2020/7/3
 * @description:
 *
 * 61. 旋转链表
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 */
public class LeetCode61 {
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        ListNode node = head;
        int len = 0;
        
        while(node != null) {
            len++;
            node = node.next;
        }
        k = k % len;
        if(k == 0){
            return head;
        }
        k = len - k;
        node = head;
        ListNode preNode = null;
        while(k > 0) {
            k--;
            if(k == 0) {
                preNode = node;
            }
            node = node.next;
            
        }
        
        if(preNode != null) {
            preNode.next = null;
        }
        
        
        ListNode newHead = node;
        
        while(node != null) {
            if(node.next == null) {
                node.next = head;
                break;
            }
            
            node = node.next;
        }
        
        return newHead;
    }
    
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        
        LeetCode61 leetCode61 = new LeetCode61();
        
        ListNode node = leetCode61.rotateRight(node1, 5);
        
        while(node != null) {
            System.out.println(node.val);
            
            node = node.next;
        }
    }
}
