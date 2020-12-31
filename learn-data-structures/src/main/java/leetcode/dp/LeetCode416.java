package leetcode.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: yeguxin
 * @date: 2020/12/31
 * @description:
 *
 * 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 */
public class LeetCode416 {
    
    public static void main(String[] args) {
        int[] nums = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100, 100, 100, 100, 100, 100, 100, 100, 100
            , 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100
            , 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100};
        LeetCode416 leetCode416 = new LeetCode416();
        boolean result = leetCode416.canPartition(nums);
        System.out.println(result);
    }
    
    /**
     * 动态规划
     *  思想参考LeetCode494 只要最后的结果等于0就说明可以存在两个子集相等. dp数组值不需要再存储方法数,而是改为是否存在两个子集.
     *
     * @param nums .
     * @return .
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0) {
            return false;
        }
        int product = sum * 2;
        boolean[][] dp = new boolean[nums.length][product + 1];
        Set<Integer> sumSet = new HashSet<>();
        if(nums[0] == 0) {
            dp[0][sum] = true;
            sumSet.add(sum);
        }else {
            dp[0][sum + nums[0]] = true;
            dp[0][sum - nums[0]] = true;
            sumSet.add(sum + nums[0]);
            sumSet.add(sum - nums[0]);
        }
        List<Integer> sumList = new ArrayList<>();
        for(int i = 1; i < nums.length; i++) {
            sumList.addAll(sumSet);
            sumSet.clear();
            for(Integer j : sumList) {
                dp[i][j + nums[i]] = dp[i][j + nums[i]] | dp[i - 1][j];
                sumSet.add(j + nums[i]);
                dp[i][j - nums[i]] = dp[i][j - nums[i]] | dp[i - 1][j];
                sumSet.add(j - nums[i]);
            }
            sumList.clear();
        }
        return dp[nums.length - 1][sum];
    }
}
