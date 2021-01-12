package leetcode.dp;

/**
 * @author: yeguxin
 * @date: 2021/1/12
 * @description:
 */
public class LeetCode123 {
    public static void main(String[] args) {
        int[] nums = {1};
        
        LeetCode123 leetCode123 = new LeetCode123();
        
        int result = leetCode123.maxProfit(nums);
        System.out.println(result);
    }
    
    /**
     * 动态规划:
     *  dp[i][j] 0<=i<=3; 0<=j<prices.length;
     *  状态转移方程:
     *      // 第一次买入股票
     *        dp[0][i] = Math.max(dp[0][i - 1], -prices[i]);
     *
     *      // 第一次卖出股票
     *        dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] + prices[i]);
     *
     *      // 第二次买入股票
     *        dp[2][i] = Math.max(dp[2][i - 1], dp[1][i - 1] - prices[i]);
     *
     *      // 第二次卖出股票
     *        dp[3][i] = Math.max(dp[3][i - 1], dp[2][i - 1] + prices[i]);
     * @param prices .
     * @return .
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[4][prices.length];
        
        if(prices.length <= 0) {
            return 0;
        }
        
        dp[0][0] = -prices[0];
        dp[2][0] = -prices[0];
        
        for(int i = 1; i < prices.length; i++) {
            // 第一次买入股票
            dp[0][i] = Math.max(dp[0][i - 1], -prices[i]);
            
            // 第一次卖出股票
            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] + prices[i]);
            
            // 第二次买入股票
            dp[2][i] = Math.max(dp[2][i - 1], dp[1][i - 1] - prices[i]);
            
            // 第二次卖出股票
            dp[3][i] = Math.max(dp[3][i - 1], dp[2][i - 1] + prices[i]);
        }
        
        return Math.max(dp[1][prices.length - 1], dp[3][prices.length - 1]);
    }
}
