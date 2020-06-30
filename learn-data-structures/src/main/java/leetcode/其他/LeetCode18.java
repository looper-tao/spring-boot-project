package leetcode.其他;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yeguxin
 * @date: 2020/6/30
 * @description:
 *
 * 18. 四数之和
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 */
public class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        
        List<List<Integer>> resultList = new ArrayList<>();
        
        int len = nums.length;
        
        for(int i = 0; i < len - 3; i++) {
            if(i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for(int j = i + 1; j < len - 2; j++) {
                if(j - i > 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1, right = len - 1;
                while(left < right) {
                    if(left - j > 1 && nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    }
                    if(right != len - 1 && nums[right] == nums[right + 1]) {
                        right--;
                        continue;
                    }
                    int num = nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if(num > target) {
                        right--;
                    }else if(num < target) {
                        left++;
                    }else {
                        resultList.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                    }
                }
            }
        }
        
        return resultList;
    }
    
    public static void main(String[] args) {
        int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        
        LeetCode18 leetCode18 = new LeetCode18();
        
        List<List<Integer>> lists = leetCode18.fourSum(nums, 0);
        
        lists.forEach(list -> {
            list.forEach(integer -> {
                System.out.print(integer + " ");
            });
            System.out.println();
        });
    }
}
