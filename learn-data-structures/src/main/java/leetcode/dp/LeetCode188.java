package leetcode.dp;

/**
 * @author: yeguxin
 * @date: 2021/1/12
 * @description:
 *
 * 188. 买卖股票的最佳时机 IV
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 *
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 *
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
