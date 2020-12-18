package leetcode.dp;

/**
 * @author: yeguxin
 * @date: 2020/12/18
 * @description: 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * <p>
 * 若这两个字符串没有公共子序列，则返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 * <p>
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 * <p>
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 */
public class LeetCode1143 {
    
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        LeetCode1143 leetCode1143 = new LeetCode1143();
        int maxResult = leetCode1143.longestCommonSubsequence(text1, text2);
        System.out.println(maxResult);
    }
    
    /**
     * 动态规划
     *  dp[i][j] 代表text1前i个字符与text2的前j个字符的最长公共子序列长度.
     *  dp[0][j] = 0; (0<=j<=m)
     *  dp[i][0] = 0; (0<=i<=n)
     *  当(str1[i-1] == str2[j-1])时 dp[i][j] = dp[i-1][j-1] +1;
     *  当(str1[i-1] != str2[j-1])时 dp[i][j] = max{dp[i][j-1],dp[i-1][j]};
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int maxResult = 0;
        for(int i = 1; i <= chars1.length; i++) {
            for(int j = 1; j <= chars2.length; j++) {
                if(chars1[i-1] == chars2[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                maxResult = maxResult < dp[i][j] ? dp[i][j] : maxResult;
            }
        }
        return maxResult;
    }
}
