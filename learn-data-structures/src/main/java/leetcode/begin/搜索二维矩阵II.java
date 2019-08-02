package leetcode.begin;

/**
 * @Author: taozhengzhi
 * @Date: 2019/7/29 下午5:08
 * @Version 1.0
 */
public class 搜索二维矩阵II {
    
    /**
     * 搜索二维矩阵 II
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
     * <p>
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * 示例:
     * <p>
     * 现有矩阵 matrix 如下：
     * <p>
     * [
     * [1,   4,  7, 11, 15],
     * [2,   5,  8, 12, 19],
     * [3,   6,  9, 16, 22],
     * [10, 13, 14, 17, 24],
     * [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     * <p>
     * 给定 target = 20，返回 false。
     *
     * @param matrix
     * @param target
     * @return
     */
    
    private static Boolean flag = false;
    
    /**
     * AC
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length - 1;
        int n = 0;
        while(m >= 0 && n < matrix[0].length) {
            if(matrix[m][n] == target) {
                return true;
            }else if(matrix[m][n] > target) {
                m--;
            }else {
                n++;
            }
        }
        return false;
    }
    
    /**
     * 使用DFS超时
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        flag = false;
        
        if(matrix.length > 0 && matrix[0].length > 0) {
            int min = matrix.length > matrix[0].length ? matrix[0].length : matrix.length;
            
            if(matrix[min - 1][min - 1] == target) {
                return true;
            }
            
            for(int k = 0; k < min; k++) {
                if(matrix[k][k] <= target && ((k + 1 >= matrix[k].length) || (k + 1 >= matrix.length) || (matrix[k + 1][k + 1] > target))) {
                    if(matrix[k][k] == target) {
                        return true;
                    }
                    dfs(matrix, target, k + 1, 0);
                    dfs(matrix, target, 0, k + 1);
                    break;
                }
            }
            
            
        }
        return flag;
    }
    
    
    public static void dfs(int[][] matrix, int target, int i, int j) {
        if(flag || i >= matrix.length || j >= matrix[0].length) {
            return;
        }
        if(target == matrix[i][j]) {
            flag = true;
            return;
        }
        if(target < matrix[i][j]) {
            return;
        }
        
        dfs(matrix, target, i + 1, j);
        dfs(matrix, target, i, j + 1);
        
    }
    
    
    public static void main(String[] args) {
        int[][] matrix = {
            {-1, 3},
            
        };
        
        int target = 3;
        boolean searchMatrix = searchMatrix(matrix, target);
        
        System.out.println("result = " + searchMatrix);
        
    }
}
