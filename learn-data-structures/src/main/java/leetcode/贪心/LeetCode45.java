package leetcode.贪心;

import leetcode.dp.LeetCode45_2;

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
public class LeetCode45 {
    public int jump(int[] nums) {
        if(nums.length <= 1) {
            return 0;
        }
        int right = nums[0];
        
        int len = nums.length - 1;
        if(right >= len) {
            return 1;
        }
        int count = 1;
        int end = nums[0];
        for(int i = 1; i <= right; i++) {
            if(right < (nums[i] + i)) {
                right = nums[i] + i;
                if(right >= len) {
                    return count+1;
                }
            }
            if(i == end){
                count++;
                end = right;
            }
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        LeetCode45 leetCode45 = new LeetCode45();
        
        int count = leetCode45.jump(nums);
        System.out.println(count);
    }
}
