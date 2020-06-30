package leetcode.其他;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author: yeguxin
 * @date: 2020/6/30
 * @description:
 *
 * 16. 最接近的三数之和
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 */
public class LeetCode16 {
    
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int len = nums.length;
        
        int resultAbs = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        
        for(int i = 0; i < len - 2; i++) {
            int left = i + 1, right = len - 1;
            
            while(left < right) {
                int num = nums[i] + nums[left] + nums[right];
                
                if(Math.abs(num - target) < resultAbs) {
                    result = num;
                    resultAbs = Math.abs(num - target);
                }
                if(num < target) {
                    left++;
                }else if(num > target) {
                    right--;
                }else {
                    return num;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        LeetCode16 leetCode16 = new LeetCode16();
        int result = leetCode16.threeSumClosest(nums, 1);
        System.out.println(result);
    }
}
