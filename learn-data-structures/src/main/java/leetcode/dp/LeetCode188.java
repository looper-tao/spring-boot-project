package leetcode.dp;

/**
 * @author: yeguxin
 * @date: 2021/1/12
 * @description:
 */
public class LeetCode188 {
    public static void main(String[] args) {
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        
        LeetCode188 leetCode188 = new LeetCode188();
        int result = leetCode188.maxProfit(k, prices);
        System.out.println(result);
    }
    
    /**
     * 动态规划: 和LeetCode123的思想一模一样,区别在于一个是固定2次买卖,一个是最多k次
     *  动态转移方程:
     *      // 第一次买入股票
     *        dp[0][i] = Math.max(dp[0][i - 1], -prices[i]);
     *      // 第(j%2)+2次买入股票
     *        dp[j][i] = Math.max(dp[j][i - 1], dp[j - 1][i - 1] - prices[i]);
     *      // 第(j%2)+1次卖出股票
     *        dp[j][i] = Math.max(dp[j][i - 1], dp[j - 1][i - 1] + prices[i]);
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k * 2][prices.length];
        
        if(prices.length <= 0) {
            return 0;
        }
        
        int maxResult = 0;
        for(int i = 0; i < k; i++) {
            dp[i * 2][0] = -prices[0];
        }
        for(int i = 1; i < prices.length; i++) {
            for(int j = 0; j < k*2; j++) {
                if(j % 2 == 0) {
                    if(j == 0) {
                        // 第一次买入股票
                        dp[j][i] = Math.max(dp[j][i - 1], -prices[i]);
                    }else {
                        // 第(j%2)+1次买入股票
                        dp[j][i] = Math.max(dp[j][i - 1], dp[j - 1][i - 1] - prices[i]);
                    }
                }else {
                    // 第(j%2)+1次卖出股票
                    dp[j][i] = Math.max(dp[j][i - 1], dp[j - 1][i - 1] + prices[i]);
                    maxResult = maxResult < dp[j][i] ? dp[j][i] : maxResult;
                }
            }
        }
        
        return maxResult;
    }
}
