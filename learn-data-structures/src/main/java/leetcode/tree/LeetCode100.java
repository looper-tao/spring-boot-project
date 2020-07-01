package leetcode.tree;

import leetcode.model.TreeNode;

/**
 * @author: yeguxin
 * @date: 2020/7/1
 * @description:
 *
 * 100. 相同的树
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 *
 */
public class LeetCode100 {
    boolean flag = true;
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        dfs(p,q);
        return flag;
        
    }
    
    public void dfs(TreeNode p, TreeNode q){
        if(!flag){
            return;
        }
        if(p!= null && q!= null && p.val == q.val){
            isSameTree(p.left,q.left);
            isSameTree(p.right,q.right);
        }else{
            if(p == null && q == null){
            
            }else{
                flag = false;
            }
        }
    }
    
    public static void main(String[] args) {
    
    }
    
}
