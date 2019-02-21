package leetcode.括号匹配问题;

import java.util.Stack;

/**
 * 题目描述:
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class LeetCode32 {
    public static void main(String[] args) {
        LeetCode32 leetCode32 = new LeetCode32();
        String s = "()";
        int i = leetCode32.longestValidParentheses(s);
        System.out.println(i);
    }
    
    /**
     * LeetCode 32 最长有效括号
     * 解题思路: 要求算最长的有效括号的问题,可以将所有的左括号入栈(因为栈的 "先进先出" 的特性),
     *          首先设定一个变量startNum 作为上一次出现完整的一小部分有效括号的起点下标,默认为0,以后如果出现 ")" 不匹配的情况就将该变量更新为下标
     *          然后对所有的右括号进行处理,会出现以下两种情况
     *              1.栈为空,表示现在没有未被匹配的 "(" 所以该 ")" 无效.
     *              2.栈不为空,将栈顶的数据弹出,
     *                  如果当前弹出之后栈内为空,则表示现在已经出现了一部分的有效括号.将比较max和上一个出现完整一小部分的有效括号的位置差取最大值
     *                  如果当前弹出之后栈内不为空,则先把当前位置下标与栈顶的 "(" 位置下标的差 算出来,与max 对比,如果比max大 则记录下来
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
