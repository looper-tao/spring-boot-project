package leetcode.其他;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class LeetCode11 {
    public static void main(String[] args) {
        LeetCode11 leetCode11 = new LeetCode11();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = leetCode11.maxArea(height);
        System.out.println(maxArea);
    }
    
    /**
     * LeetCode20 11 盛最多水的容器
     * 解题思路: 因为要计算那个区间才能存储最多的水,所以先看一下水是如何来存储的,很显然一个区间内能存储多少的水,取决于这个区间两端中较短的那一方(木桶原理)
     *          所以一个区间内的水的容量 = 较短一方的长度 * 这个区间的宽度
     *          将区间确定好,然后比较这个区间的两端,较短的那一方向较长的那一段移动(因为移动较短的那一段可以保证不会出现有更大面积的区间不会被计算到的问题)
     *          直至区间的两端移动到一起.
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
