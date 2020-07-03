package leetcode.dp;

/**
 * @author: yeguxin
 * @date: 2020/7/3
 * @description:
 *
 * 63. 不同路径 II
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
public class LeetCode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0) {
            return 1;
        }
        int n = obstacleGrid[0].length;
        
        int[][] nums = new int[m][n];
        boolean flag = true;
        for(int i = 0; i < m; i++) {
            if(flag && obstacleGrid[i][0] == 0) {
                nums[i][0] = 1;
            }else {
                nums[i][0] = 0; ;
                flag = false;
            }
            
        }
        flag = true;
        for(int i = 0; i < n; i++) {
            if(flag && obstacleGrid[0][i] == 0) {
                nums[0][i] = 1;
            }else {
                nums[0][i] = 0;
                flag = false;
            }
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1){
                    nums[i][j] = 0;
                }else{
                    nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
                }
            }
        }
        
        return nums[m - 1][n - 1];
    }
    
    public static void main(String[] args) {
        LeetCode63 leetCode63 = new LeetCode63();
        int[][] nums = {
            {1}
        };
        int result = leetCode63.uniquePathsWithObstacles(nums);
    
        System.out.println(result);
    }
}
