package leetcode.begin;

/**
 * @Author: taozhengzhi
 * @Date: 2019/7/29 下午4:24
 * @Version 1.0
 */
public class 只出现一次的数字 {
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * <p>
     * 说明：
     * <p>
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * <p>
     * 示例 1:
     * <p>
     * 输入: [2,2,1]
     * 输出: 1
     * 示例 2:
     * <p>
     * 输入: [4,1,2,1,2]
     * 输出: 4
     */
    
    public static int singleNumber(int[] nums) {
        int num=0;
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                num = nums[0];
            }else {
                num = num ^ nums[i];
            }
        }
        System.out.println(num);
        return num;
    }
    
    public static void main(String[] args) {
        int[] num = {1,1,2,3,4,5,6,5,4,3,2,1000,10000,1000,10000};
        只出现一次的数字.singleNumber(num);
    }
}
