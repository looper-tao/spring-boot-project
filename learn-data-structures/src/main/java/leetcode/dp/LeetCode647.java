package leetcode.dp;

/**
 * @author: yeguxin
 * @date: 2021/3/23
 * @description:
 *
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 *
 * 提示：
 *
 * 输入的字符串长度不会超过 1000 。
 *
 */
public class LeetCode647 {
    
    public static void main(String[] args) {
        LeetCode647 leetCode647 = new LeetCode647();
        
        int result = leetCode647.countSubstrings("aaa");
        System.out.println(result);
        
    }
    
    /**
     * 动态规划做法
     *  dp[i][j] 表示 i到j的字符串子串是否是一个回文串,是为: true 不是为: false
     *  然后计算总的数量
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        char[] strArray = s.toCharArray();
        boolean[][] dp = new boolean[strArray.length][strArray.length];
        
        for(int i = 0; i < strArray.length; i++) {
            for(int j = 0; j < (strArray.length - i); j++) {
                if(i == 0) {
                    dp[j][j] = true;
                }else{
                    if((strArray[j] == strArray[j+i]) && (i == 1  || dp[j+1][j+i-1])){
                        dp[j][j+i] = true;
                    }
                }
                
            }
        }
        
        int result = 0;
        for(int i = 0; i < strArray.length; i++) {
            for(int j = i; j < strArray.length; j++) {
                result += dp[i][j] ? 1 : 0;
            }
        }
        
        return result;
    }
}
