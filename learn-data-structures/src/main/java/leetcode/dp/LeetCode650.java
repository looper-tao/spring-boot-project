package leetcode.dp;

/**
 * @author: yeguxin
 * @date: 2020/12/22
 * @description:
 */
public class LeetCode650 {
    public static void main(String[] args) {
        LeetCode650 leetCode650 = new LeetCode650();
        int minSteps = leetCode650.minSteps(8);
        System.out.println(minSteps);
    }
    
    /**
     * 动态规划
     *  状态转移方程为: if n为非素数 dp[n] = j + dp[n/j];
     *               if n为素数   dp[n] = n;
     * @param n
     * @return
     */
    public int minSteps(int n) {
        if(n == 1){
            return 0;
        }
        int[] dp = new int[n + 1];
        for(int i = 2; i <= n; i++) {
            dp[i] = i;
        }
        
        for(int i=2;i<=n;i++){
            for(int j=2;j<=i;j++){
                if(i%j == 0){
                    dp[i] = Math.min(dp[i],  j+dp[i/j]);
                }
            }
        }
        
        return dp[n];
    }
}
