package jianzhioffer.fibonacci;

/**
 * @author: yeguxin
 * @date: 2019/12/23
 * @description: 跳台阶问题
 *
 * 题目描述：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 问题分析：
 * 正常分析法： a.如果两种跳法，1阶或者2阶，那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1);
 *           b.假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)
 *           c.由a，b假设可以得出总跳法为: f(n) = f(n-1) + f(n-2)
 *           d.然后通过实际的情况可以得出：只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2
 * 找规律分析法： f(1) = 1, f(2) = 2, f(3) = 3, f(4) = 5， 可以总结出f(n) = f(n-1) + f(n-2)的规律。
 *
 */
public class QingWaTaiJie {
    
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
    
        System.out.println(qingwataijie(40));
        Long endTime = System.currentTimeMillis();
        System.out.println("耗时: "+(endTime-startTime));
    }
    
    /**
     * 斐波那契数列解法
     * @param n
     * @return
     */
    public static int qingwataijie(int n){
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        
        if(n == 2){
            return 2;
        }
        
        return qingwataijie(n-1) + qingwataijie(n-2);
    }
}
