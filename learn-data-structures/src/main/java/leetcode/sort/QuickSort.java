package leetcode.sort;

import java.util.Arrays;

/**
 * 快速排序算法
 * @author: yeguxin
 * @date: 2019/11/5
 * @description:
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10,9,12,8,14,13,7,11,6,5,4,3,2,1};
        
        System.out.println("排序前");
        for(int i:arr) {
            System.out.print(i+ "    ");
        }
        System.out.println();
        System.out.println();
        
        // 快速排序
        quickSort(arr,0,arr.length-1);
    
        System.out.println("排序后");
        for(int i:arr) {
            System.out.print(i+ "    ");
        }
        System.out.println();
    }
    
    /**
     * 从小到大排序
     * @param list
     * @param left
     * @param right
     */
    public static void quickSort(int[] list, int left, int right) {
        if(left >= right){
            return;
        }
        int l = left;
        int r = right;
        
        // 找一个基点数字num,并且把该基点数字赋值到一个临时变量上,这时候基点所在的位置就空出来了
        int num = list[l];
        
        while(l < r){
            // 因为基点数字是在最左边,所以从最右边开始找一个比基点数字小的值,
            // 如果在右边找到了一个比基点小的值,则将左边空出来的位置放入在右边找到的比基点小的那个数字,
            while(l < r && list[r] > num){
                r--;
            }
            if(l<r){
                list[l++] = list[r];
            }
            
            // 因为右边的数字填充到了左边的空闲位置,这时候右边的位置就空闲出来了
            // 这时候从左边找一个比基点数字更大的值,
            // 如果在左边找到了一个比基点大的值,则将在右边的空闲的位置放入在左边找到的比基点大的那个数字
            while(l< r && list[l] < num){
                l++;
            }
            if(l<r){
                list[r--] = list[l];
            }
            
        }
        
        list[l] = num;
        
        
        // 经过刚刚的操作,就形成了一个以基点为界的数组
        // 基点左边的数字全部小于基点
        // 基点右边的数字全部大于基点
        // 将基点左边的那一段为一个数组进行刚刚的操作,一直递归下去
        quickSort(list,left,l-1);
        // 将基点右边的那一段为一个数组进行刚刚的操作,一直递归下去
        quickSort(list,l+1,right);
    }
}
