package leetcode.其他;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class LeetCode42 {
    public static void main(String[] args) {
        LeetCode42 leetCode42 = new LeetCode42();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = leetCode42.trap(height);
        System.out.println(trap);
    }
    
    /**
     * LeetCode 42 接雨水
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int size = height.length;
        if(size <= 0) {
            return 0;
        }
        int max = -1;
        int flag = -1;
        for(int i = 0; i < size; i++) {
            if(max < height[i]) {
                max = height[i];
                flag = i;
            }
        }
        
        int result = 0;
        int heigh = height[0];
        for(int i = 0; i < flag; i++) {
            if(heigh < height[i]) {
                heigh = height[i];
            }else {
                result += heigh - height[i];
            }
        }
        
        heigh = height[size - 1];
        for(int i = size - 1; i >= flag; i--) {
            if(heigh < height[i]) {
                heigh = height[i];
            }else {
                result += heigh - height[i];
            }
        }
        return result;
    }
    
}
