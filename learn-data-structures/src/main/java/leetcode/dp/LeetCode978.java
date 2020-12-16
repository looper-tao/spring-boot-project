package leetcode.dp;

/**
 * @author: yeguxin
 * @date: 2020/12/16
 * @description: 978. 最长湍流子数组
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 * <p>
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * <p>
 * 返回 A 的最大湍流子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 * 示例 2：
 * <p>
 * 输入：[4,8,12,16]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：[100]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 * 通过次数11,824提交次数27,931
 */
public class LeetCode978 {
    public static void main(String[] args) {
        LeetCode978 leetCode978 = new LeetCode978();
//        int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        int[] arr = {4,8,12,16};
        int maxResult = leetCode978.maxTurbulenceSize(arr);
        System.out.println(maxResult);
    }
    
    /**
     * 动态规划解法
     *  假设 dp[0][i] 表示 index为偶数时 符号为 arr[index-1] > arr[index] < arr[index+1]
     *      dp[1][i] 表示 index为奇数时 符号为 arr[index-1] < arr[index] > arr[index+!]
     *  状态转移方程:
     *      dp[0][i] = Math.max(dp[0][i], dp[0][i - 1] + 1);
     *      dp[1][i] = Math.max(dp[1][i], dp[1][i - 1] + 1);
     *
     * @param arr
     * @return
     */
    public int maxTurbulenceSize(int[] arr) {
        int[][] dp = new int[2][arr.length];
        
        for(int i = 0; i < arr.length; i++) {
            dp[0][i] = 1;
            dp[1][i] = 1;
        }
        
        int maxResult = 1;
        for(int i = 1; i < arr.length; i++) {
            if(i % 2 != 0) {
                if(arr[i] < arr[i - 1]) {
                    dp[0][i] = Math.max(dp[0][i], dp[0][i - 1] + 1);
                    maxResult = maxResult < dp[0][i] ? dp[0][i] : maxResult;
                }else if(arr[i] > arr[i - 1]){
                    dp[1][i] = Math.max(dp[1][i], dp[1][i - 1] + 1);
                    maxResult = maxResult < dp[1][i] ? dp[1][i] : maxResult;
                }
            }else {
                if(arr[i] > arr[i - 1]) {
                    dp[0][i] = Math.max(dp[0][i], dp[0][i - 1] + 1);
                    maxResult = maxResult < dp[0][i] ? dp[0][i] : maxResult;
                }else if(arr[i] < arr[i - 1]){
                    dp[1][i] = Math.max(dp[1][i], dp[1][i - 1] + 1);
                    maxResult = maxResult < dp[1][i] ? dp[1][i] : maxResult;
                }
            }
        }
        return maxResult;
    }
}
