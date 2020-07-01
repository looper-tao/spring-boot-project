package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yeguxin
 * @date: 2020/7/1
 * @description:
 *
 * 39. 组合总和
 *
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 */
public class LeetCode39 {
    List<Integer> valueList = new ArrayList<>();
    List<List<Integer>> resultList = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, 0, target);
        
        return resultList;
    }
    
    public void dfs(int[] candidates, int left, int index, int sum, int target) {
        if(sum == target) {
            List<Integer> numList = new ArrayList<>();
            numList.addAll(valueList);
            resultList.add(numList);
        }
        if(sum > target) {
            return;
        }
        int len = candidates.length;
        
        for(int i = left; i < len; i++) {
            if((sum+candidates[i]) > target){
                return;
            }
            valueList.add(candidates[i]);
            dfs(candidates, i, index + 1, sum + candidates[i], target);
            valueList.remove(index);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        LeetCode39 leetCode39 = new LeetCode39();
        List<List<Integer>> lists = leetCode39.combinationSum(nums, 8);
        lists.forEach(list -> {
            list.forEach(integer -> {
                System.out.print(integer + " ");
            });
            System.out.println();
            
        });
    }
}
