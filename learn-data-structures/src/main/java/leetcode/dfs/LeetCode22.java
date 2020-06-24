package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yeguxin
 * @date: 2020/6/24
 * @description: 22. 括号生成
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class LeetCode22 {
    
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        
        if(n <= 0) {
            return result;
        }
        dfs("", n, n, result);
        
        return result;
    }
    
    public void dfs(String str, int left, int right, List<String> result) {
        if(left == 0 && right == 0) {
            result.add(str);
        }
        
        if(left > right) {
            return;
        }
        if(left > 0) {
            dfs(str + "(", left - 1, right, result);
        }
        if(right > 0) {
            dfs(str + ")", left, right - 1, result);
        }
    }
    
    
    public static void main(String[] args) {
        LeetCode22 leetCode22 = new LeetCode22();
        
        List<String> list = leetCode22.generateParenthesis(3);
        list.forEach(System.out::println);
    }
}
