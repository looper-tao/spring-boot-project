package leetcode.search.binary;

/**
 * @author: yeguxin
 * @date: 2020/6/30
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class LeetCode34 {
    
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = searchLeft(nums, target);
        int rightIndex = searchRight(nums, target);
        
        return new int[]{leftIndex, rightIndex};
    }
    
    public int searchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        int mid;
        while(left <= right) {
            mid = (left + right) / 2;
            
            if(nums[mid] < target) {
                left = mid + 1;
            }else if(nums[mid] > target) {
                right = mid - 1;
            }else {
                if(mid - 1 >= 0 && nums[mid - 1] == target) {
                    right = mid - 1;
                }else {
                    return mid;
                }
            }
            
        }
        
        return -1;
    }
    
    public int searchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        int mid;
        while(left <= right) {
            mid = (left + right) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            }else if(nums[mid] > target) {
                right = mid - 1;
            }else {
                if(mid + 1 < nums.length && nums[mid + 1] == target) {
                    left = mid + 1;
                }else {
                    return mid;
                }
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        
        LeetCode34 leetCode34 = new LeetCode34();
        
        int[] range = leetCode34.searchRange(nums, 1);
        
        for(int i = 0; i < range.length; i++) {
            System.out.print(range[i] + "  ");
        }
        
    }
}
