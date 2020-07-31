package leetcode.disjointsets;

import java.util.HashMap;
import java.util.Map;


/**
 * @author: yeguxin
 * @date: 2020/7/30
 * @description:
 *
 * 130. 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class LeetCode130 {
    private Map<Integer, Boolean> unionMap = new HashMap<>();
    private Map<Integer, Boolean> isUsedMap = new HashMap<>();
    
    public void solve(char[][] board) {
        int colLen = board.length;
        int rowLen = 0;
        if(colLen > 0) {
            rowLen = board[0].length;
        }
        for(int i = 0; i < colLen; i++) {
            for(int j = 0; j < rowLen; j++) {
                if(board[i][j] == 'O') {
                    unionMap.put(i * board[i].length + j, Boolean.FALSE);
                    isUsedMap.put(i * rowLen + j, Boolean.FALSE);
                }
            }
        }
        
        if(colLen > 0) {
            for(int i = 0; i < board[0].length; i++) {
                if(board[0][i] == 'O') {
                    dfs(board, 0, i);
                }
            }
            for(int i = 0; i < board[0].length; i++) {
                if(board[board.length - 1][i] == 'O') {
                    dfs(board, board.length - 1, i);
                }
            }
            
            for(int i = 1; i < board.length - 1; i++) {
                if(board[i][0] == 'O') {
                    dfs(board, i, 0);
                }
            }
            
            for(int i = 1; i < board.length - 1; i++) {
                if(board[i][board[0].length - 1] == 'O') {
                    dfs(board, i, board[0].length - 1);
                }
            }
        }
        
        for(int i = 0; i < colLen; i++) {
            for(int j = 0; j < rowLen; j++) {
                if(board[i][j] == 'O' && !unionMap.get(i * rowLen + j)) {
                    board[i][j] = 'X';
                }
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        
    }
    
    public void dfs(char[][] board, int i, int j) {
        if(i >= board.length || j >= board[0].length || i < 0 || j < 0) {
            return;
        }
        int num = i * board[0].length + j;
        
        if(board[i][j] != 'O' || isUsedMap.get(num).equals(Boolean.TRUE)) {
            return;
        }
        unionMap.put(num, Boolean.TRUE);
        if(!isUsedMap.get(num)) {
            isUsedMap.put(num, Boolean.TRUE);
            dfs(board, i - 1, j);
            dfs(board, i + 1, j);
            dfs(board, i, j - 1);
            dfs(board, i, j + 1);
        }
    }
    
    public static void main(String[] args) {
        char[][] board = {
            {'X', 'O', 'X', 'O', 'X', 'O'},
            {'O', 'X', 'O', 'X', 'O', 'X'}, 
            {'X', 'O', 'X', 'O', 'X', 'O'},
            {'O', 'X', 'O', 'X', 'O', 'X'}
        };
        LeetCode130 leetCode130 = new LeetCode130();
        leetCode130.solve(board);
    }
    
}
