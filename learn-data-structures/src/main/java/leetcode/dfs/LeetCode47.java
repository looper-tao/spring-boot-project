package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yeguxin
 * @date: 2020/7/1
 * @description:
 *
 * 47. 全排列 II
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 */
public class LeetCode47 {
    private List<List<Integer>> resultList = new ArrayList<>();
    
    boolean[] flag;
    Integer[] value;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        flag = new boolean[len];
        value = new Integer[len];
    
    
        dfs(nums, 0, len);
    
        return resultList;
    }
    
    public void dfs(int[] nums, int count, int len) {
        if(count == len) {
            List<Integer> integerList = new ArrayList<>();
            integerList.addAll(Arrays.asList(value));
            
            resultList.add(integerList);
        }
        
        for(int i = 0; i < len; i++) {
            if(!flag[i]) {
                if( (i>0 && nums[i-1] == nums[i]&& !flag[i-1])){
                    continue;
                }
                flag[i] = true;
                value[count] = nums[i];
                dfs(nums, count + 1, len);
                flag[i] = false;
            }
        }
    }
    
    
    public static void main(String[] args) {
        int[] nums = {1,1,3};
    
        LeetCode47 leetCode47 = new LeetCode47();
    
        List<List<Integer>> permuteList = leetCode47.permuteUnique(nums);
    
        permuteList.forEach(list -> {
            list.forEach(integer -> {
                System.out.print(integer + " ");
            });
            System.out.println();
        
        });
    }
}
