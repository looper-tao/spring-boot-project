package leetcode.list;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: yeguxin
 * @date: 2020/4/27
 * @description:
 */
public class FindMedianSortedArraysDemo {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] nums2 = {7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        
        System.out.println(findMedianSortedArrays(nums1, nums2));
        
    }
    
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int minLength = nums1.length > nums2.length ? nums2.length : nums1.length;
        int maxLength = nums1.length > nums2.length ? nums1.length : nums2.length;
        
        int[] minList = nums1.length > nums2.length ? nums2 : nums1;
        int[] maxList = nums1.length > nums2.length ? nums1 : nums2;
        
        if(minLength == 0) {
            if(maxLength % 2 == 0) {
                return maxList[maxLength / 2] + maxList[maxLength / 2 + 1];
            }else {
                return maxList[maxLength / 2];
            }
        }
        
        int sum = minLength + maxLength;
        int mid = (maxLength + minLength - 1) / 2;
        
        boolean flag = sum % 2 == 0 ? false : true;
        int j = 0;
        for(int i = mid; i >= 0 && j < minLength; ) {
            if(minList[j] >= maxList[i]) {
                if(j == minLength - 1) {
                    if(flag) {
                        return maxList[i/2];
                    }else {
                        return (maxList[i] + maxList[i - 1]) / 2.0;
                    }
                }else {
                    i--;
                    j++;
                }
            }else {
                if(flag) {
                    return maxList[i] / 1.0;
                }else {
                    return (maxList[i] + minList[j]) / 2.0;
                }
            }
        }
        
        return 0;
        
    }
}
