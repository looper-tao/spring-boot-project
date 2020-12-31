package leetcode.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: yeguxin
 * @date: 2020/12/30
 * @description:
 *
 * 494. 目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 *
 *
 * 示例：
 *
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 *
 *
 * 提示：
 *
 * 数组非空，且长度不会超过 20 。
 * 初始的数组的和不会超过 1000 。
 * 保证返回的最终结果能被 32 位整数存下。
 * 通过次数57,581提交次数129,423
 *
 */
public class LeetCode494 {
    public static void main(String[] args) {
        int[] nums = {2,107,109,113,127,131,137,3,2,3,5,7,11,13,17,19,23,29,47,53};
        LeetCode494 leetCode494 = new LeetCode494();
        int result = leetCode494.findTargetSumWays(nums, 2147483647);
        System.out.println(result);
    }
    
    /**
     * 动态规划
     *  状态转移方程:
     *       dp[i][j + nums[i]] = dp[i][j+nums[i]] + dp[i-1][j];
     *       dp[i][j-nums[i]] = dp[i][j-nums[i]] + dp[i-1][j];
     *  dp[i][j]代表数组0~i中结果为j的方法数.因为会有负数,所以将数组的整数之和*2.让负数的值+sum >0
     * @param nums .
     * @param S .
     * @return .
     */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(S+sum < 0){
            return 0;
        }
        int[][] dp = new int[nums.length][2 * sum+1];
        
        Set<Integer> sumSet = new HashSet<>();
        
        if(nums[0] == 0) {
            dp[0][sum] = 2;
            sumSet.add(sum);
        }else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
            sumSet.add(sum + nums[0]);
            sumSet.add(sum - nums[0]);
        }
        List<Integer> sumList = new ArrayList<>();
        for(int i = 1; i < nums.length; i++) {
            sumList.addAll(sumSet);
            sumSet.clear();
            for(Integer j : sumList) {
                dp[i][j + nums[i]] = dp[i][j+nums[i]] + dp[i-1][j];
                sumSet.add(j + nums[i]);
                dp[i][j-nums[i]] = dp[i][j-nums[i]] + dp[i-1][j];
                sumSet.add(j - nums[i]);
            }
            sumList.clear();
        }
        return ((sum+S) > 2*sum) ? 0 :  dp[nums.length-1][sum+S];
    }
}
