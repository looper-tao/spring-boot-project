package nowcoder.Link;

import lombok.Data;

/**
 * @author: yeguxin
 * @date: 2019/12/26
 * @description:
 */
@Data
public class ListNode {
    public int val;
    public ListNode next = null;
    
    ListNode(int val) {
        this.val = val;
    }
    
    public ListNode() {
    }
    
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
