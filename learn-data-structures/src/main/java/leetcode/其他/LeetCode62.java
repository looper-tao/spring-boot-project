package leetcode.其他;

/**
 * @author: yeguxin
 * @date: 2020/7/3
 * @description:
 *
 * 62. 不同路径
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 *  
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 *  
 */
public class LeetCode62 {
    
    public int uniquePaths(int m, int n) {
        int[][] nums = new int[m][n];
        for(int i=0;i<m;i++){
            nums[i][0] = 1;
        }
        for(int i=0;i<n;i++){
            nums[0][i] = 1;
        }
    
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                nums[i][j] = nums[i-1][j] + nums[i][j-1];
            }
        }
    
        return nums[m-1][n-1];
        
    }
    
    public static void main(String[] args) {
        LeetCode62 leetCode62 = new LeetCode62();
    
        int result = leetCode62.uniquePaths(1, 1);
        System.out.println(result);
    }
}
