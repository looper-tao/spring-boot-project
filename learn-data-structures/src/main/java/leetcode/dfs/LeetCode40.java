package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yeguxin
 * @date: 2020/7/1
 * @description:
 *
 * 40. 组合总和 II
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 */
public class LeetCode40 {
    List<Integer> valueList = new ArrayList<>();
    List<List<Integer>> resultList = new ArrayList<>();
    
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
            if((sum + candidates[i]) > target) {
                return;
            }
            if(i > left && candidates[i] == candidates[i - 1]) {
                continue;
            }
            valueList.add(candidates[i]);
            dfs(candidates, i + 1, index + 1, sum + candidates[i], target);
            valueList.remove(index);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, 0, target);
        
        return resultList;
    }
    
    
    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        LeetCode40 leetCode40 = new LeetCode40();
        List<List<Integer>> lists = leetCode40.combinationSum2(nums, 8);
        lists.forEach(list -> {
            list.forEach(integer -> {
                System.out.print(integer + " ");
            });
            System.out.println();
            
        });
    }
}
