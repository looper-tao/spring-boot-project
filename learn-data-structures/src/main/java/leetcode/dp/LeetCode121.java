package leetcode.dp;

/**
 * @author: yeguxin
 * @date: 2021/1/8
 * @description: 121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class LeetCode121 {
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        LeetCode121 leetCode121 = new LeetCode121();
        int result = leetCode121.maxProfit(nums);
        System.out.println(result);
    }
    
    /**
     * 找该index之前最低的价格并用当前价格 相减得到的最大值即为结果
     * @param prices .
     * @return .
     */
    public int maxProfit(int[] prices) {
        if(prices.length <= 0){
            return 0;
        }
        int[] dp = new int[prices.length];
        
        dp[0] = -prices[0];
        int result = 0;
        for(int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], -prices[i]);
            result = (result < (prices[i] + dp[i - 1])) ? (prices[i] + dp[i - 1]) : result;
        }
        
        return result;
    }
}
