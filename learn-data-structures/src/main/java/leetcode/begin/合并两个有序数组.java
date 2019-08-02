package leetcode.begin;

import javafx.scene.SubScene;
import org.apache.poi.util.ArrayUtil;

import java.util.Arrays;

/**
 * @Author: taozhengzhi
 * @Date: 2019/7/30 下午3:04
 * @Version 1.0
 */
public class 合并两个有序数组 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] c = new int[nums1.length];
        int flag = nums1.length - 1;
        
        System.arraycopy(nums1, 0, c, 0, m);

        System.arraycopy(nums2, 0, c, m, n);
    

        
        Arrays.sort(c);
        
        
        int k = -1;
        
        for(int i = 0; i < c.length; i++) {
            nums1[++k] = c[i];
        }
        
        for(int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
        
    }
    
    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 0, 3, 3, 3, 0, 0, 0};
        int[] nums2 = {1, 2, 2};
        
        merge(nums1, 6, nums2, 3);
        
    }
}
