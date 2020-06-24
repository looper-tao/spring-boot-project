package leetcode.linkedlist;

import nowcoder.Link.ListNode;

import javax.validation.constraints.Null;

/**
 * @author: yeguxin
 * @date: 2020/6/24
 * @description: 19. 删除链表的倒数第N个节点
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */
public class LeetCode19 {
    
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        ListNode temp = head;
        while(node != null) {
            if(n < 0) {
                temp = temp.getNext();
            }
            n--;
            node = node.getNext();
        }
        if(n >= 0) {
            head = temp.getNext();
        }else {
            temp.setNext(temp.getNext().getNext());
        }
        
        return head;
    }
    
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node = removeNthFromEnd(node1, 5);
        while(node != null) {
            System.out.println(node.getVal());
            node = node.getNext();
        }
    }
}
