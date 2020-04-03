package nowcoder.tree;

import nowcoder.tree.TreeNode;

/**
 * @author: yeguxin
 * @date: 2020/1/2
 * @description:
 */
public class TreeDemo {
    private static int max = 0;
    private static int min = 999999999;
    
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode3.right = treeNode6;
        treeNode5.left = treeNode7;
        IsBalanced_Solution(treeNode1);
        
    }
    
    /**
     * 求二叉树的深度
     *
     * @param root
     * @return
     */
    public int treeDepth(TreeNode root) {
        getMaxTreeDepth(root, 0);
        return max;
    }
    
    public static void getMaxTreeDepth(TreeNode root, int depth) {
        if(root != null) {
            depth++;
            getMaxTreeDepth(root.left, depth);
            getMaxTreeDepth(root.right, depth);
        }else {
            max = max > depth ? max : depth;
        }
    }
    
    public static void getMinTreeDepth(TreeNode root, int depth) {
        if(root != null) {
            depth++;
            getMinTreeDepth(root.left, depth);
            getMinTreeDepth(root.right, depth);
        }else {
            min = min > depth ? depth : min;
        }
    }
    
    /**
     * 判断一棵树是不是一颗二叉查找树
     *
     * @param root
     * @return
     */
    public boolean IsSearch_Solution(TreeNode root) {
        if(root != null) {
            if(root.left != null && root.val <= root.left.val) {
                return false;
            }
            if(root.right != null && root.val >= root.right.val) {
                return false;
            }
            return this.IsSearch_Solution(root.left) && this.IsSearch_Solution(root.right);
        }
        return true;
    }
    
    public static boolean IsBalanced_Solution(TreeNode root) {
        return depthTree(root)!=-1;
    }
    
    
    public static int depthTree(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = depthTree(root.left);
        if(left == -1){
            return -1;
        }
        int right = depthTree(root.right);
        if(right == -1){
            return -1;
        }
        if(left > (right+1) || (left+1) < right){
            return -1;
        }else {
            return 1+(left > right ? left:right);
        }
    }
}
