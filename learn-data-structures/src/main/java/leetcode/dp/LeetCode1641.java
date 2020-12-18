package leetcode.dp;

/**
 * @author: yeguxin
 * @date: 2020/12/18
 * @description:
 */
public class LeetCode1641 {
    public static void main(String[] args) {
        int n = 33;
        LeetCode1641 leetCode1641 = new LeetCode1641();
        int result = leetCode1641.countVowelStrings(n);
        System.out.println(result);
    }
    
    
    /**
     * 为方便表达将元音[a,e,i,o,u]替换为[1,2,3,4,5]
     *
     * 观察n=1时
     *  1 2 3 4 5
     * 观察n=2时
     *  11 12 13 14 15
     *     22 23 24 25
     *        33 34 35
     *           44 45
     *              55
     * 观察n=3时
     *  111 112 113 114 115
     *      122 123 124 125
     *          133 134 135
     *              144 145
     *                  155
     *      222 223 224 225
     *          233 234 235
     *              244 245
     *                  255
     *          333 334 335
     *              344 345
     *                  355
     *              444 445
     *                  455
     *                  555
     * 现在将长度为n的字符串分为5个部分即:
     *                              结尾为1的字符串
     *                              结尾为2的字符串
     *                              结尾为3的字符串
     *                              结尾为4的字符串
     *                              结尾为5的字符串
     * 可以发现:
     *          当一个n长度的字符串结尾为1时, 使用的是n-1长度的结尾为1的全部
     *          当一个n长度的字符串结尾为2时, 使用的是n-1长度的结尾为1+2的全部
     *          当一个n长度的字符串结尾为3时, 使用的是n-1长度的结尾为1+2+3的全部
     *          当一个n长度的字符串结尾为4时, 使用的是n-1长度的结尾为1+2+3+4的全部
     *          当一个n长度的字符串结尾为5时, 使用的是n-1长度的结尾为1+2+3+4+5的全部
     * 由此状态转移方程可以写为:
     *             dp[i][0] = dp[i - 1][0];
     *             dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
     *             dp[i][2] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
     *             dp[i][3] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3];
     *             dp[i][4] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4];
     * 然后对于dp[n][0~4]求和就可以了
     * @param n
     * @return
     */
    public int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][5];
        dp[1] = new int[]{1, 1, 1, 1, 1};
        
        for(int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
            dp[i][3] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3];
            dp[i][4] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4];
        }
        return dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4];
    }
}
