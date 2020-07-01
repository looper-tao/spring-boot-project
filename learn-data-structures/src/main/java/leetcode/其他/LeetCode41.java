package leetcode.其他;

/**
 * @author: yeguxin
 * @date: 2020/7/1
 * @description:
 *
 * 41. 缺失的第一个正数
 *
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 */
public class LeetCode41 {
    
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        boolean isHaveOne = false;
        for(int i = 0; i < len; i++) {
            if(nums[i] == 1) {
                isHaveOne = true;
            }
            if(nums[i] <= 0) {
                nums[i] = 1;
            }
        }
        
        if(!isHaveOne){
            return 1;
        }
        for(int i = 0; i < len; i++) {
            if(Math.abs(nums[i]) <= len) {
                if(nums[Math.abs(nums[i]) - 1] > 0) {
                    nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
                }
            }
        }
        
        for(int i = 0; i < len; i++) {
            if(nums[i] > 0) {
                return i+1;
            }
        }
        
        return len + 1;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 4, -1,1};
        
        LeetCode41 leetCode41 = new LeetCode41();
        
        int result = leetCode41.firstMissingPositive(nums);
        
        System.out.println(result);
    }
}
