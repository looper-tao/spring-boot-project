package leetcode.其他;

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
