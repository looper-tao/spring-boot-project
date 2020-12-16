package leetcode.dp;

/**
 * @author: yeguxin
 * @date: 2020/12/16
 * @description: 787. K 站中转内最便宜的航班
 * 有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
 * <p>
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * 输出: 200
 * 解释:
 * 城市航班图如下
 * <p>
 * <p>
 * 从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
 * 示例 2：
 * <p>
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * 输出: 500
 * 解释:
 * 城市航班图如下
 * <p>
 * <p>
 * 从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n 范围是 [1, 100]，城市标签从 0 到 n - 1
 * 航班数量范围是 [0, n * (n - 1) / 2]
 * 每个航班的格式 (src, dst, price)
 * 每个航班的价格范围是 [1, 10000]
 * k 范围是 [0, n - 1]
 * 航班没有重复，且不存在自环
 */
public class LeetCode787 {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{1,2,100},{0,2,500},{0,1,100}};
        int src = 0, dst = 2, k = 3;
        LeetCode787 leetCode787 = new LeetCode787();
        int minResult = leetCode787.findCheapestPrice(n, edges, src, dst, k);
        System.out.println(minResult);
    }
    
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] dp = new int[n][K+1];
        for(int i = 0; i < n; i++) {
            for(int k = 0; k <= K; k++) {
                if(i == src) {
                    dp[i][k] = 0;
                }else {
                    dp[i][k] = 0x7fffffff;
                }
            }
        }
    
        for(int[] flight : flights) {
            if(flight[0] == src) {
                dp[flight[1]][0] = flight[2];
            }
        }
        
        for(int i = 1; i <= K; i++) {
            for(int[] flight : flights) {
                if(dp[flight[0]][i - 1] != 0x7fffffff) {
                    dp[flight[1]][i] = Math.min(dp[flight[1]][i], (dp[flight[0]][i - 1] + flight[2]));
                }
            }
        }
        int minResult = 0x7fffffff;
        for(int i=0;i<=K;i++){
            minResult = minResult > dp[dst][i] ? dp[dst][i] : minResult;
        }
        return minResult==0x7fffffff ? -1 : minResult;
    }
}
