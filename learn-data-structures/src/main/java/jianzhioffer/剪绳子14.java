package jianzhioffer;

/**
 * @author: yeguxin
 * @date: 2020/12/18
 * @description:
 */
public class 剪绳子14 {
    public static void main(String[] args) {
        int n = 120;
        剪绳子14 c = new 剪绳子14();
        int result = c.cuttingRope(n);
        System.out.println(result);
    }
    
    public int cuttingRope(int n) {
        if(n==2){
            return 1;
        }else if(n==3){
            return 2;
        }else if(n == 4){
            return 4;
        }else if(n== 5){
            return 6;
        }
        
        int count = n/3;
        int num = n%3;
        if(num == 0 || num == 1){
            count = count - 1;
            num = num + 3;
        }
        int p=1000000007;
        long result = 1;
        while(count > 0){
            result = (result * 3) % p;
            count--;
        }
        result = (result * num) % p;
        
        return (int) result;
    }
}
