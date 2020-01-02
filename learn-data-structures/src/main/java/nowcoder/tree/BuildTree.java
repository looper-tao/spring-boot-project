package nowcoder.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yeguxin
 * @date: 2019/12/25
 * @description: 重建二叉树
 */
public class BuildTree {
    private Map<Integer, Integer> zhongxuMap = new HashMap<>();
    
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 6, 7, 5, 8, 9, 3, 10, 11};
        int[] in = {6, 4, 7, 2, 8, 5, 9, 1, 10, 3, 11};
        BuildTree b = new BuildTree();
        b.printTree(b.reConstructBinaryTree1(pre, in));
    }
    
    public TreeNode reConstructBinaryTree1(int[] pre, int[] in) {
        for(int i = 0; i < in.length; i++) {
            zhongxuMap.put(in[i], i);
        }
        return build(pre, 0, pre.length - 1, 0);
    }
    
    public TreeNode build(int[] pre, int left, int right, int fatherNode) {
        if(left > right) {
            return null;
        }
        TreeNode node = new TreeNode(pre[left]);
        int size = zhongxuMap.get(node.val);
        int leftTreeSize = size - fatherNode;
        if((left + 1) <= (left + leftTreeSize))
            System.out.println("左子树: node= " + node.val + "     " + (left + 1) + "    " + (left + leftTreeSize) + "    " + fatherNode);
        node.left = build(pre, left + 1, left + leftTreeSize, fatherNode);
        if((left + leftTreeSize + 1) <= right)
            System.out.println("右子树: node= " + node.val + "     " + (left + leftTreeSize + 1) + "     " + right + "    " + (size + 1));
        node.right = build(pre, left + leftTreeSize + 1, right, size + 1);
        
        return node;
    }
    
    
    public void printTree(TreeNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.val + " , ");
        printTree(node.left);
        printTree(node.right);
        
    }
}
