package leetcode.dp;

/**
 * @author: yeguxin
 * @date: 2020/7/1
 * @description:
 *
 * 45. 跳跃游戏 II
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 */
public class LeetCode45_2 {
    
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        int len = nums.length;
        
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len && j <= nums[i] + i; j++) {
                if(dp[j] > 0) {
                    dp[j] = dp[i] < dp[j] ? dp[i] + 1 : dp[j];
                }else {
                    dp[j] = dp[i] + 1;
                }
                
            }
        }
        
        return dp[len-1];
    }
    
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,1,1,1,4};
        LeetCode45_2 leetCode45 = new LeetCode45_2();
    
        int count = leetCode45.jump(nums);
        System.out.println(count);
    }
}
