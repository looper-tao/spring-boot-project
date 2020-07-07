package leetcode.sort;

/**
 * @author: yeguxin
 * @date: 2020/7/6
 * @description: 75. 颜色分类
 * <p>
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class LeetCode75 {
    
    public void sortColors(int[] nums) {
//        QuickSort.quickSort(nums,0,nums.length-1);
        
        heapSort(nums);
    }
    
    private void heapSort(int[] nums) {
        heapInsert(nums);
        
        int len = nums.length;
        
        while(len > 1) {
            swap(nums, len - 1, 0);
            len--;
            buildHeap(nums, 0, len);
        }
    }
    
    private void heapInsert(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int index = i;
            
            int fatherIndex = (i - 1) / 2;
            
            while(nums[fatherIndex] < nums[index]) {
                swap(nums, fatherIndex, index);
                
                index = fatherIndex;
                fatherIndex = (index - 1) / 2;
            }
        }
    }
    
    private void buildHeap(int[] nums, int index, int len) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        
        while(left < len) {
            int maxIndex = left;
            if(right < len && nums[right] > nums[left]) {
                maxIndex = right;
            }
            
            if(nums[index] > nums[maxIndex]) {
                break;
            }else {
                swap(nums, index, maxIndex);
                index = maxIndex;
                left = 2 * maxIndex + 1;
                right = 2 * maxIndex + 2;
            }
        }
    }
    
    private void swap(int[] nums, int fatherIndex, int index) {
        int temp = nums[fatherIndex];
        nums[fatherIndex] = nums[index];
        nums[index] = temp;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 4, 9, 8, 0, 7, 6, 100, 1, 0};
        LeetCode75 leetCode75 = new LeetCode75();
        
        leetCode75.sortColors(nums);
        
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "  ");
        }
    }
}
