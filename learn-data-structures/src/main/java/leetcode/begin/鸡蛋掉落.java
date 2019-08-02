package leetcode.begin;

/**
 * @Author: taozhengzhi
 * @Date: 2019/8/1 下午1:41
 * @Version 1.0
 */
public class 鸡蛋掉落 {
    public static int superEggDrop(int K, int N) {
        int[][] dp = new int[K+1][N+1];
        
        for(int n=1;n<=N;n++){
            dp[0][n] = 0;
            for(int k=1;k<=K;k++){
                dp[k][n] = dp[k-1][n-1] + dp[k][n-1] + 1;
                if(dp[k][n] >= N){
                    return n;
                }
            }
        }
        
        
        return N;
    }
    
    public static void main(String[] args) {
        int K = 2, N = 6;
        int eggDrop = superEggDrop(K, N);
        System.out.println("eggDrop = "+eggDrop);
    }
}
