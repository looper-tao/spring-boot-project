package leetcode.dfs;

/**
 * @author: yeguxin
 * @date: 2020/7/1
 * @description:
 *
 * 45. 跳跃游戏 II(使用DFS超时)
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
 *
 */
public class LeetCode45_1 {
    int min = Integer.MAX_VALUE;
    
    public int jump(int[] nums) {
        dfs(nums,0,0,0);
        
        return min;
    }
    
    public void dfs(int[] nums, int left, int right, int count) {
        if(right >= nums.length-1) {
            min = min > count ? count : min;
        }
        
        if(left >= nums.length){
            return;
        }
        
        right = (right >= nums.length-1) ? nums.length-1:right;
        for(int i = left; i <= right; i++) {
            dfs(nums,i+1,nums[i]+i,count+1);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {2,1};
        
        LeetCode45_1 leetCode45 = new LeetCode45_1();
    
        int count = leetCode45.jump(nums);
        
        System.out.println(count);
    
    
    }
}
