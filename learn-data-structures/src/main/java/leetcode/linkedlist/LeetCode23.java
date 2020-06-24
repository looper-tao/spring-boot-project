package leetcode.linkedlist;

import nowcoder.Link.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yeguxin
 * @date: 2020/6/24
 * @description:
 */
public class LeetCode23 {
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length<=0){
            return null;
        }
        while(lists.length > 1) {
            List<ListNode> listNodes = new ArrayList<>();
            for(int i = 0; i < lists.length-1;) {
                ListNode node = mergeTwoLists(lists[i], lists[i + 1]);
                listNodes.add(node);
                i = i + 2;
            }
            if(lists.length % 2 != 0){
                listNodes.add(lists[lists.length-1]);
            }
            lists = (ListNode[]) listNodes.toArray(new ListNode[listNodes.size()]);
        }
        
        return lists[0];
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            if(l1 != null) {
                return l1;
            }else if(l2 != null) {
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
        if(l1 == null) {
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
    
        ListNode node12 = new ListNode(23, null);
        ListNode node11 = new ListNode(1, node12);
    
        LeetCode23 leetCode23 = new LeetCode23();
        ListNode[] listNodes = {node1,node6,node11};
        ListNode listNode = leetCode23.mergeKLists(listNodes);
        while(listNode !=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    
    }
}
