package leetcode.dp;

/**
 * @author: yeguxin
 * @date: 2020/12/24
 * @description:
 *
 * 714. 买卖股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 示例 1:
 *
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 注意:
 *
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 *
 */
public class LeetCode714 {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        
        LeetCode714 leetCode714 = new LeetCode714();
        int result = leetCode714.maxProfit3(prices, fee);
        System.out.println(result);
    }
    
    /**
     * 动态规划(第三版)
     *  dp[0] 代表当前没有持有股票
     *  dp[1] 代表当前正在持有股票, 默认的dp[1] 为第一天的价格.
     *  动态转移方程
     *      不持有股票的状态: max(当天没有进行股票交易的收益,或者当天进行了股票交易收益)
     *          dp[0] = Math.max(dp[0],prices[i]+dp[1]-fee);
     *      持有股票的状态: max(当天没有进行股票交易的收益,当天进行了股票交易的收益)
     *          dp[1] = Math.max(dp[1],dp[0]-prices[i])
     *  是否AC: 是
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit3(int[] prices, int fee) {
        int[] dp = new int[2];
        // 代表当前没有持有股票
        dp[0] = 0;
        // 代表当前持有股票 默认第一天持有股票.这时需要花费 prices[0]的费用
        dp[1] = -prices[0];
        
        for(int i=1;i<prices.length;i++){
            dp[0] = Math.max(dp[0],prices[i]+dp[1]-fee);
            dp[1] = Math.max(dp[1],dp[0]-prices[i]);
        }
        
        return dp[0];
    }
    
    /**
     * 动态规划(第二版)
     *  dp[i]代表第i天最大的股票收益
     *      状态转移方程:
     *          第i天的最大收益等于第j天的最大收益 + 第i天的价格卖出第j+1天的股票
     *          dp[i] = Math.max(dp[i],dp[j - 1] + profits);
     *  是否AC: 否, 超时
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit2(int[] prices, int fee) {
        int[] dp = new int[prices.length];
        
        int max = 0;
        for(int i = 1; i < prices.length; i++) {
            for(int j = 0; j < i; j++) {
                int profits = prices[i] - prices[j] - fee;
                if(j - 1 > 0 && profits > 0) {
                    dp[i] = Math.max(dp[i],dp[j - 1] + profits);
                }else if(profits > 0){
                    dp[i] = profits;
                }
                max = max < dp[i] ? dp[i]:max;
                dp[i] = max;
            }
        }
        
        return max;
    }
    
    /**
     * 动态规划(第一版)
     *  dp[i][j] 代表第i天买入股票,第j天卖出股票 + i天之前的股票的最大收益
     *  状态转移方程为:
     *      max为第i天之前的最大的股票收益
     *      dp[i][j] = (prices[j] - prices[i]) - fee + max;
     *  是否AC: 否, 超内存
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][prices.length];
        
        int maxResult = Integer.MIN_VALUE;
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            for(int j = 0; j < i; j++) {
                max = max < dp[j][i - 1] ? dp[j][i - 1] : max;
            }
            for(int j = i + 1; j < prices.length; j++) {
                max = (max == Integer.MIN_VALUE || max < 0) ? 0 : max;
                dp[i][j] = (prices[j] - prices[i]) - fee + max;
                maxResult = maxResult < dp[i][j] ? dp[i][j] : maxResult;
            }
        }
        return maxResult > 0 ? maxResult : 0;
    }
    
    
}
