package leetcode.字符串问题;

/**
 * 题目描述:
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LeetCode3 {
    public static void main(String[] args) {
        LeetCode3 leetCode3 = new LeetCode3();
        String s = "abbbbbba";
        int ans = leetCode3.lengthOfLongestSubstring(s);
        System.out.println(ans);
    }
    
    /**
     * LeetCode 3. 无重复字符的最长子串
     *
     * 解题思路 : 因为是要求算无重复的最长子串,所以可以采用两次遍历的方法,截取其中的所有可能性,
     *           然后去掉其中可能出现的重复子串,剩下的最大值就是要求的结果.
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int maxNum = 1;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length - 1; i++) {
            for(int j = i + 1; j < chars.length; j++) {
                String substring = s.substring(i, j);
                if(substring.contains(String.valueOf(chars[j]))) {
                    break;
                }else {
                    maxNum = (j - i + 1) > maxNum ? (j - i + 1) : maxNum;
                }
            }
        }
        return maxNum;
    }
}
