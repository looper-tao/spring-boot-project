package jianzhioffer.fibonacci;

/**
 * @author: yeguxin
 * @date: 2019/12/23
 * @description: 斐波那契数列实现
 */
public class FibonacciBase {
    
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        
        System.out.println(buildFibonaciiByRecursion(40));
        Long endTime = System.currentTimeMillis();
        System.out.println("耗时: "+(endTime-startTime));
    }
    
    /**
     * 迭代方式实现斐波那契数列
     * @param n
     * @return
     */
    private static int buildFibonaciiByIteration(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        int first = 1;
        int second = 1;
        int result = 0;
        for(int i=3;i<=n;i++){
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
    
    /**
     * 使用递归方式实现斐波那契数列
     * @param n
     * @return
     */
    private static int buildFibonaciiByRecursion(int n){
        if(n <= 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        
        return buildFibonaciiByRecursion(n-1) + buildFibonaciiByRecursion(n-2);
    }
    
    
}
