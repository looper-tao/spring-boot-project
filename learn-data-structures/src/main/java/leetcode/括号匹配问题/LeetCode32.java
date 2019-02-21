package leetcode.括号匹配问题;

import java.util.Stack;

public class LeetCode32 {
    public static void main(String[] args) {
        LeetCode32 leetCode32 = new LeetCode32();
        String s = "()(()";
        int i = leetCode32.longestValidParentheses(s);
        System.out.println(i);
    }
    
    /**
     * LeetCode 32 最长有效括号
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        char[] stringArray = s.toCharArray();
        int max = 0;
        int startNum = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < stringArray.length; i++) {
            if('(' == stringArray[i]) {
                stack.push(i);
            }else if(')' == stringArray[i]) {
                if(stack.empty()) {
                    startNum = i + 1;
                }else {
                    stack.pop();
                    if(stack.empty()) {
                        max = Math.max(max, i - startNum + 1);
                    }else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        return max;
    }
}
