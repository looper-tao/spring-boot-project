package leetcode.search.binary;

/**
 * @author: yeguxin
 * @date: 2020/7/6
 * @description:
 *
 * 74. 搜索二维矩阵
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */
public class LeetCode74 {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        if(rowLen <= 0) {
            return false;
        }
        int colLen = matrix[0].length;
        if(colLen <= 0) {
            return false;
        }
        int rowIndex = -1;
        for(int i = 0; i < rowLen; i++) {
            if(matrix[i][0] <= target) {
                rowIndex = i;
            }else {
                break;
            }
        }
        if(rowIndex == -1) {
            return false;
        }
        int left = 0, right = matrix[rowIndex].length - 1;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(matrix[rowIndex][mid] > target) {
                right = mid - 1;
            }else if(matrix[rowIndex][mid] < target) {
                left = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {}
        };
        
        LeetCode74 leetCode74 = new LeetCode74();
        
        boolean result = leetCode74.searchMatrix(matrix, 120);
        
        System.out.println(result);
    }
}
