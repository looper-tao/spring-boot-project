package leetcode.search.binary;

/**
 * @author: yeguxin
 * @date: 2020/6/30
 * @description:
 *
 * 35. 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 */
public class LeetCode35 {
    
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        
        int left = 0, right = len - 1;
        int mid = -1;
        while(left <= right) {
            mid = (left + right) / 2;
            
            if(nums[mid] > target) {
                right = mid - 1;
            }else if(nums[mid] < target) {
                left = mid + 1;
            }else {
                return mid;
            }
            
        }
        return nums[mid] > target ? mid:mid+1;
        
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        
        LeetCode35 leetCode35 = new LeetCode35();
        
        int index = leetCode35.searchInsert(nums, 4);
        
        System.out.println(index);
    }
}
