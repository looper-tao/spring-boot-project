package leetcode.dp;

/**
 * @author: yeguxin
 * @date: 2020/12/30
 * @description:
 *
 * 1262. 可被三整除的最大和
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 *
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 *
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 *
 */
public class LeetCode1262 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        
        LeetCode1262 leetCode1262 = new LeetCode1262();
        int result = leetCode1262.maxSumDivThree(nums);
        System.out.println(result);
    }
    
    /**
     * 动态规划
     *  状态转移方程:
     *      nums[i] % 3 == 0
     *         dp[i][0] = dp[i - 1][0] + nums[i];
     *         dp[i][1] = dp[i - 1][1] + nums[i];
     *         dp[i][2] = dp[i - 1][2] + nums[i];
     *      nums[i] % 3 == 1
     *         dp[i][0] = Math.max(dp[i - 1][0], (dp[i - 1][2] + nums[i]) % 3 == 0 ? (dp[i - 1][2] + nums[i]) : 0);
     *         dp[i][1] = Math.max(dp[i - 1][1], (dp[i - 1][0] + nums[i]) % 3 == 1 ? (dp[i - 1][0] + nums[i]) : 0);
     *         dp[i][2] = Math.max(dp[i - 1][2], (dp[i - 1][1] + nums[i]) % 3 == 2 ? (dp[i - 1][1] + nums[i]) : 0);
     *      nums[i] % 3 == 2
     *         dp[i][0] = Math.max(dp[i - 1][0], (dp[i - 1][1] + nums[i]) % 3 == 0 ? (dp[i - 1][1] + nums[i]) : 0);
     *         dp[i][1] = Math.max(dp[i - 1][1], (dp[i - 1][2] + nums[i]) % 3 == 1 ? (dp[i - 1][2] + nums[i]) : 0);
     *         dp[i][2] = Math.max(dp[i - 1][2], (dp[i - 1][0] + nums[i]) % 3 == 2 ? (dp[i - 1][0] + nums[i]) : 0);
     *  最后取能被0整除的dp[nums.length][0]
     *
     * @param nums
     * @return
     */
    public int maxSumDivThree(int[] nums) {
        int[][] dp = new int[nums.length][3];
        
        int first = nums[0];
        if(first % 3 == 0) {
            dp[0][0] = first;
        }else if(first % 3 == 1) {
            dp[0][1] = first;
        }else {
            dp[0][2] = first;
        }
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] % 3 == 0) {
                dp[i][0] = dp[i - 1][0] + nums[i];
                dp[i][1] = dp[i - 1][1] + nums[i];
                dp[i][2] = dp[i - 1][2] + nums[i];
            }else if(nums[i] % 3 == 1) {
                dp[i][0] = Math.max(dp[i - 1][0], (dp[i - 1][2] + nums[i]) % 3 == 0 ? (dp[i - 1][2] + nums[i]) : 0);
                dp[i][1] = Math.max(dp[i - 1][1], (dp[i - 1][0] + nums[i]) % 3 == 1 ? (dp[i - 1][0] + nums[i]) : 0);
                dp[i][2] = Math.max(dp[i - 1][2], (dp[i - 1][1] + nums[i]) % 3 == 2 ? (dp[i - 1][1] + nums[i]) : 0);
            }else {
                dp[i][0] = Math.max(dp[i - 1][0], (dp[i - 1][1] + nums[i]) % 3 == 0 ? (dp[i - 1][1] + nums[i]) : 0);
                dp[i][1] = Math.max(dp[i - 1][1], (dp[i - 1][2] + nums[i]) % 3 == 1 ? (dp[i - 1][2] + nums[i]) : 0);
                dp[i][2] = Math.max(dp[i - 1][2], (dp[i - 1][0] + nums[i]) % 3 == 2 ? (dp[i - 1][0] + nums[i]) : 0);
            }
        }
        return dp[nums.length - 1][0];
    }
}
