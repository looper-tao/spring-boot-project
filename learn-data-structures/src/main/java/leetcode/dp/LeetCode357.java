package leetcode.dp;

/**
 * @author: yeguxin
 * @date: 2020/12/22
 * @description:
 *
 * 357. 计算各个位数不同的数字个数
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 *
 * 示例:
 *
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 */
public class LeetCode357 {
    private int[] num = {9,9,8,7,6,5,4,3,2,1};
    public static void main(String[] args) {
        LeetCode357 leetCode357 = new LeetCode357();
        int result = leetCode357.countNumbersWithUniqueDigits(3);
        System.out.println(result);
    }
    
    /**
     * 动态规划
     *
     * 动态转移方程: dp[n] = product(n) + dp[n-1];
     *
     * 其中product的计算方式为:
     *  当n=3时 也就是一个三位数,当拿着0~9这10个数字去进行排列组合时.
     *      百位数的可选择数为9个 (1~9)
     *      十位数的可选择数为9个 (1~9中去除被百位数上选择掉的1位(8) + 0 = 9)
     *      个位数的可选择数为8个 (0~9中去除百位&十位上被选择掉的2位(8))
     *
     * 以此类推
     *
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 10;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 10;
        if(n >=10){
            n = 10;
        }
        for(int i=2;i<=n;i++){
            int product = 1;
            for(int j=0;j<i;j++){
                product *= num[j];
            }
            dp[i] = product + dp[i-1];
        }
        
        return dp[n];
    }
    
}
