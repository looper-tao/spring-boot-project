package leetcode.其他;

public class LeetCode11 {
    public static void main(String[] args) {
        LeetCode11 leetCode11 = new LeetCode11();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = leetCode11.maxArea(height);
        System.out.println(maxArea);
    }
    
    /**
     * LeetCode 11 盛最多水的容器
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while(l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if(height[l] < height[r])
                l++;
            else
                r--;
        }
        return max;
    }
}
