package leetcode.dp;

/**
 * @author: yeguxin
 * @date: 2021/1/12
 * @description:
 *
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 */
public class LeetCode309 {
    
    public static void main(String[] args) {
        int[] nums = {2,1,4};
        
        LeetCode309 leetCode309 = new LeetCode309();
        int result = leetCode309.maxProfit(nums);
        System.out.println(result);
    }
    
    /**
     * 动态规划
     *  状态转移方程:
     *      dp[0][i] = Math.max(dp[0][i-1],dp[1][i-1]+prices[i]);
     *
     *      if(i>=2){
     *         dp[1][i] = Math.max(dp[1][i-1],dp[0][i-2]-prices[i]);
     *      }else{
     *         dp[1][i] = Math.max(dp[1][i-1],-prices[i]);
     *      }
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[2][prices.length];
        
        if(prices.length <=0){
            return 0;
        }
        
        // 持有
        dp[1][0] = -prices[0];
        
        for(int i = 1; i < prices.length; i++) {
            dp[0][i] = Math.max(dp[0][i-1],dp[1][i-1]+prices[i]);
            
            if(i>=2){
                dp[1][i] = Math.max(dp[1][i-1],dp[0][i-2]-prices[i]);
            }else{
                dp[1][i] = Math.max(dp[1][i-1],-prices[i]);
            }
        }
        
        return dp[0][prices.length-1];
    }
}
