package leetcode.dp;

import leetcode.model.TreeNode;

/**
 * @author: yeguxin
 * @date: 2021/1/5
 * @description:
 *
 * 337. 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 * 通过次数79,728提交次数131,036
 *
 */
public class LeetCode337 {
    public static void main(String[] args) {
        LeetCode337 leetCode337 = new LeetCode337();
        int result = leetCode337.rob(null);
        System.out.println(result);
    }
    
    /**
     * 递归做法
     *  获取的最大金额为: Math.max((本节点.val + 所有的孙节点.val),(所有子节点.val)) 并以此递归
     * @param root .
     * @return .
     */
    public int rob(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int result1 = root.val;
        int result2 = 0;
        if(root.left != null) {
            result1 += rob(root.left.left) + rob(root.left.right);
            result2 += rob(root.left);
        }
        if(root.right != null) {
            result1 += rob(root.right.left) + rob(root.right.right);
            result2 += rob(root.right);
        }
        return Math.max(result1, result2);
        
    }
    
    
}
