package leetcode.dp;

/**
 * @author: yeguxin
 * @date: 2021/1/12
 * @description:
 *
 * 123. 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
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
