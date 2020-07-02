package leetcode.tree;

import leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yeguxin
 * @date: 2020/7/2
 * @description:
 *
 * 94. 二叉树的中序遍历
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 */
public class LeetCode94 {
    
    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        
        ldr(root);
        
        return result;
    }
    
    public void ldr(TreeNode root) {
        if(root == null) {
            return;
        }
        
        
        ldr(root.left);
        result.add(root.val);
        ldr(root.right);
        
    }
    
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        node2.left = node3;
        TreeNode node1 = new TreeNode(1);
        node1.right = node2;
        
        LeetCode94 leetCode94 = new LeetCode94();
        
        leetCode94.inorderTraversal(node1);
        
    }
}
