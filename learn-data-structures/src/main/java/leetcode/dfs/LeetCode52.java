package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yeguxin
 * @date: 2020/7/3
 * @description:
 *
 * 52. N皇后 II
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *  
 *
 * 提示：
 *
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步，可进可退。（引用自 百度百科 - 皇后 ）
 *
 */
public class LeetCode52 {
    int result = 0;
    
    public boolean isSelect(int row, int col, int[] values) {
        for(int i = 0; i < row; i++) {
            if(col == values[i] || (row + col) == (i + values[i]) || (row - i) == (col - values[i])) {
                return false;
            }
        }
        return true;
    }
    
    public void dfs(int row, int n, int[] values) {
        if(row == n) {
            result++;
            return;
        }
        for(int i = 0; i < n; i++) {
            if(isSelect(row, i, values)) {
                values[row] = i;
                dfs(row + 1, n, values);
            }
        }
        
    }
    
    public int totalNQueens(int n) {
        result = 0;
        
        dfs(0,n,new int[n]);
        
        return result;
    }
    
    public static void main(String[] args) {
        LeetCode52 leetCode52  = new LeetCode52();
    
        int count = leetCode52.totalNQueens(4);
        
        System.out.println(count);
    }
}
