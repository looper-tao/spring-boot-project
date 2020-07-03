package leetcode.dfs;

/**
 * @author: yeguxin
 * @date: 2020/7/3
 * @description:
 *
 * 63. 不同路径 II(使用深度优先遍历超时)
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class LeetCode63_1 {
    int count = 0;
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        if(m == 0) {
            return 1;
        }
        int n = obstacleGrid[0].length;
        
        dfs(obstacleGrid, m, n, 0, 0);
        
        return count;
    }
    
    public void dfs(int[][] obstacleGrid, int m, int n, int row, int col) {
        if(row >= m || n <= col) {
            return;
        }
        
        if(row == m - 1 && n - 1 == col && obstacleGrid[row][col] == 0) {
            count++;
        }
        if(m >= row && obstacleGrid[row][col] == 0) {
            dfs(obstacleGrid, m, n, row + 1, col);
        }
        if(n >= col && obstacleGrid[row][col] == 0) {
            dfs(obstacleGrid, m, n, row, col + 1);
        }
        
    }
    
    public static void main(String[] args) {
        LeetCode63_1 leetCode63 = new LeetCode63_1();
        int[][] nums = {
            {1}
        };
        int result = leetCode63.uniquePathsWithObstacles(nums);
        
        System.out.println(result);
    }
}
