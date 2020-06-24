package leetcode.dynamic;

/**
 * @author: yeguxin
 * @date: 2020/6/24
 * @description: 5. 最长回文子串
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LeetCode5 {
    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        boolean[][] dp = new boolean[length][length];
        
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                dp[i][j] = false;
            }
            dp[i][i] = true;
        }
        
        for(int j = 0; j < length; j++) {
            for(int i = 0; i < j; i++) {
                if(chars[i] == chars[j] && ((j < i + 3) || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        
        int max = 0;
        int begin = 0;
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
//                System.out.print(dp[i][j]+" ");
                if(dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    begin = i;
                }
            }
            System.out.println();
        }
        return s.substring(begin, begin + max);
    }
    
    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }
}
