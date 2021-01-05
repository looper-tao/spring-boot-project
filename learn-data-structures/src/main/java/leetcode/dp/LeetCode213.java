package leetcode.dp;

/**
 * @author: yeguxin
 * @date: 2021/1/5
 * @description:
 *
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 */
public class LeetCode213 {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 7, 5, 3, 1};
        LeetCode213 leetCode213 = new LeetCode213();
        int result = leetCode213.rob(nums);
        System.out.println(result);
    }
    
    /**
     * 动态规划
     *  根据题意,相邻的房屋不能偷,而且是个环形.这个时候就要确定是不偷第一间还是不偷最后一间.
     *  故状态转移方程为:
     *      dp[i][j]  0<=i<=1, 0<=j<nums.length. 当i为0时代表不偷第一间,当i为1时代表不偷最后一间.最后比一下两个的最大值.
     *      dp[0][i] = Math.max(dp[0][i - 1], dp[0][i - 2] + nums[i]);
     *      dp[1][i] = Math.max(dp[1][i - 1], dp[1][i - 2] + nums[i]);
     * @param nums .
     * @return .
     */
    public int rob(int[] nums) {
        int[][] dp = new int[2][nums.length];
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        dp[1][0] = nums[0];
        dp[0][0] = 0;
        dp[0][1] = nums[1];
        dp[1][1] = nums[1] > nums[0] ? nums[1] : nums[0];
        for(int i = 2; i < nums.length - 1; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[0][i - 2] + nums[i]);
            dp[1][i] = Math.max(dp[1][i - 1], dp[1][i - 2] + nums[i]);
        }
        dp[0][nums.length - 1] = Math.max(dp[0][nums.length - 1 - 1], dp[0][nums.length - 1 - 2] + nums[nums.length - 1]);
        return dp[0][nums.length - 1] > dp[1][nums.length - 2] ? dp[0][nums.length - 1] : dp[1][nums.length - 2];
    }
}
