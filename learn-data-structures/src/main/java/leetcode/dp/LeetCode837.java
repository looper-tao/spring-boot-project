package leetcode.dp;

/**
 * @author: yeguxin
 * @date: 2020/12/17
 * @description: 837. 新21点
 * 爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
 * <p>
 * 爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。 每次抽取都是独立的，其结果具有相同的概率。
 * <p>
 * 当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：N = 10, K = 1, W = 10
 * 输出：1.00000
 * 说明：爱丽丝得到一张卡，然后停止。
 * 示例 2：
 * <p>
 * 输入：N = 6, K = 1, W = 10
 * 输出：0.60000
 * 说明：爱丽丝得到一张卡，然后停止。
 * 在 W = 10 的 6 种可能下，她的得分不超过 N = 6 分。
 * 示例 3：
 * <p>
 * 输入：N = 21, K = 17, W = 10
 * 输出：0.73278
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= K <= N <= 10000
 * 1 <= W <= 10000
 * 如果答案与正确答案的误差不超过 10^-5，则该答案将被视为正确答案通过。
 * 此问题的判断限制时间已经减少。
 */
public class LeetCode837 {
    
    public static void main(String[] args) {
        int N = 21, K = 17, W = 10;
        LeetCode837 leetCode837 = new LeetCode837();
        double result = leetCode837.new21Game(N, K, W);
        System.out.println(result);
    }
    
    /**
     * 动态规划
     * dp[i] 代表得分为i时胜的概率. 因为当得分到达K时就停止发牌.每次发牌的分数范围在[1,w].
     *  那么可以认为停止发牌时 爱丽丝手上的得分在[K,K+w].其中 一旦停止发牌,爱丽丝是输是赢就已经确定了,
     *  所以停止发牌后分数在dp[K],dp[K+1]...dp[N]的胜率为1.份数在dp[N+1]....dp[K+w]的胜率为0
     *  由题意可知 "每次抽取都是独立的，其结果具有相同的概率"所以 当得分为K-1时抽到 [K,K+w]的任何一个的概率是一样的.
     *  故状态转移方程可以写成 dp[k-1] = 1/w * (dp[k]+dp[k+1]+dp[k+2] + ... + dp[k+w])
     *
     * @param N
     * @param K
     * @param W
     * @return
     */
    public double new21Game(int N, int K, int W) {
        double[] dp = new double[K + W];
        double temp = 0;
        for(int i = K; i < K + W; i++) {
            dp[i] = i <= N ? 1 : 0;
            temp += dp[i];
        }
        
        for(int i = K - 1; i >= 0; i--) {
            dp[i] = temp / W;
            temp = temp - dp[i + W] + dp[i];
        }
        return dp[0];
    }
}
