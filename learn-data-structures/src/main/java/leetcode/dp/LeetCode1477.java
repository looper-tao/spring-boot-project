package leetcode.dp;

import java.util.Arrays;

/**
 * @author: yeguxin
 * @date: 2021/1/13
 * @description:
 */
public class LeetCode1477 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 3, 2, 3, 1};
        
        LeetCode1477 leetCode1477 = new LeetCode1477();
        int result = leetCode1477.minSumOfLengths(nums, 6);
        System.out.println(result);
    }
    
    public int minSumOfLengths(int[] arr, int target) {
        int[] dp = new int[arr.length];
        
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        
        int left = 0, right = 0;
        int len = arr.length;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        while(left < len && right < len) {
            sum += arr[right++];
            
            while(left < right && sum > target) {
                sum -= arr[left++];
            }
            if(sum == target) {
                dp[right] = right - left + 1;
                if(left != 0) {
                    result = Math.min(result, dp[left - 1] + right - left + 1);
                }
            }
            if(right != 0) {
                dp[right] = Math.min(dp[right - 1], dp[right]);
            }
        }
        return result > len ? -1 : result;
    }
}
