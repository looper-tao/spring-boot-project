package leetcode.dp;

/**
 * @author: yeguxin
 * @date: 2021/3/22
 * @description:
 *
 * 1039. 多边形三角剖分的最低得分
 * 给定 N，想象一个凸 N 边多边形，其顶点按顺时针顺序依次标记为 A[0], A[i], ..., A[N-1]。
 *
 * 假设您将多边形剖分为 N-2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 N-2 个三角形的值之和。
 *
 * 返回多边形进行三角剖分后可以得到的最低分。
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3]
 * 输出：6
 * 解释：多边形已经三角化，唯一三角形的分数为 6。
 * 示例 2：
 *
 *
 *
 * 输入：[3,7,4,5]
 * 输出：144
 * 解释：有两种三角剖分，可能得分分别为：3*7*5 + 4*5*7 = 245，或 3*4*5 + 3*4*7 = 144。最低分数为 144。
 * 示例 3：
 *
 * 输入：[1,3,1,4,1,5]
 * 输出：13
 * 解释：最低分数三角剖分的得分情况为 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13。
 *
 *
 * 提示：
 *
 * 3 <= A.length <= 50
 * 1 <= A[i] <= 100
 *
 */
public class LeetCode1039 {
    public static void main(String[] args) {
        LeetCode1039 leetCode1039 = new LeetCode1039();
        
        int result = leetCode1039.minScoreTriangulation(new int[]{1,3,1,4,1,5});
        System.out.println(result);
    }
    
    /**
     * 动态规划做法
     *  求一个多边形的最低得分首先先求这个多边型一部分的最低得分.
     *  每次求多边形一部分的最低得分时,先确定一条三角形底边,该三角形的底边和底边两个顶点之间顶点可以任意组成最多三个部分,
     *      分别为: dp[j][k],和dp[k][i] 和由i,j,k三个顶点组成的三角形,
     *  由于顶点j倒序查找, dp[j][k]和 dp[k][i]的最小值已经在上一步得到,所以只需要进行加法操作就可以了
     *
     * @param values
     * @return
     */
    public int minScoreTriangulation(int[] values) {
        int length = values.length;
        if(values == null || length <= 0) {
            return 0;
        }
        int[][] dp = new int[length][length];
        
        for(int i = 2; i < length; i++) {
            for(int j = i - 2; j >= 0; j--) {
                for(int k = j + 1; k <= i - 1; k++) {
                    if(dp[j][i] == 0) {
                        dp[j][i] = dp[j][k] + values[j] * values[k] * values[i] + dp[k][i];
                    }else {
                        dp[j][i] = Math.min(dp[j][i], (dp[j][k] + values[j] * values[k] * values[i] + dp[k][i]));
                    }
                }
            }
        }
        
        return dp[0][length - 1];
    }
    
}
