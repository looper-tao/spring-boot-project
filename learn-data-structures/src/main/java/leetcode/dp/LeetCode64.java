package leetcode.dp;

/**
 * @author: yeguxin
 * @date: 2020/7/3
 * @description:
 *
 * 64. 最小路径和
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class LeetCode64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m == 0) {
            return 1;
        }
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < m; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
            dp[i][0] = grid[i][0];
        }
        for(int i = 1; i < n; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
            dp[0][i] = grid[0][i];
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j],dp[i][j - 1] + grid[i][j]);
            }
        }
        
        return dp[m - 1][n - 1];
    }
    
    public static void main(String[] args) {
        int[][] nums = {
            {1}
        };
        
        LeetCode64 leetCode64 = new LeetCode64();
    
        int result = leetCode64.minPathSum(nums);
        
        System.out.println(result);
    }
}
