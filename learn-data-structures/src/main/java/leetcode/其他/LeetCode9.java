package leetcode.其他;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: yeguxin
 * @date: 2020/6/24
 * @description: 9. 回文数
 * <p>
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class LeetCode9 {
    
    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        
        while(x > 0) {
            int remainder = x % 10;
            stack.push(remainder);
            queue.add(remainder);
            x = x / 10;
        }
        
        while(!stack.empty()) {
            if(stack.pop().compareTo(queue.pop()) != 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isPalindrome(-0));
    }
}
