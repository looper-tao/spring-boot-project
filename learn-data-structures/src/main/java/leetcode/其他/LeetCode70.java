package leetcode.其他;

/**
 * @author: yeguxin
 * @date: 2020/7/1
 * @description:
 *
 * 70. 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 */
public class LeetCode70 {
    
    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        int one = 1;
        int two = 2;
        
        int result = 0;
        for(int i = 3; i <= n; i++) {
            result = one + two;
            
            one = two;
            two = result;
        }
        
        return result;
        
        
    }
    
    /**
     * 递归算法超时
     * @param n
     * @return
     */
    public int dfs(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        
        return dfs(n - 1) + dfs(n - 2);
    }
    
    public static void main(String[] args) {
        LeetCode70 leetCode70 = new LeetCode70();
        
        int climbStairs = leetCode70.climbStairs(6);
        
        System.out.println(climbStairs);
    }
}
