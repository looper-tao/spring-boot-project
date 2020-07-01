package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yeguxin
 * @date: 2020/7/1
 * @description:
 *
 * 46. 全排列
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class LeetCode46 {
    private List<List<Integer>> resultList = new ArrayList<>();
    
    boolean[] flag;
    Integer[] value;
    
    public List<List<Integer>> permute(int[] nums) {
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
                flag[i] = true;
                value[count] = nums[i];
                dfs(nums, count + 1, len);
                flag[i] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        
        LeetCode46 leetCode46 = new LeetCode46();
    
        List<List<Integer>> permuteList = leetCode46.permute(nums);
    
        permuteList.forEach(list -> {
            list.forEach(integer -> {
                System.out.print(integer + " ");
            });
            System.out.println();
        
        });
    }
}
