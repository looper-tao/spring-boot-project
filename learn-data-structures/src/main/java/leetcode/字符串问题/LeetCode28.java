package leetcode.字符串问题;

/**
 * @author: yeguxin
 * @date: 2020/6/29
 * @description:
 *
 * 28. 实现 strStr()
 *
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 */
public class LeetCode28 {
    
    public int[] getNext(char[] needleCharArray) {
        int length = needleCharArray.length;
        int[] next = new int[length+1];
        
        next[0] = -1;
        int i = 0, j = -1;
        
        while(i < length) {
            if(j == -1 || needleCharArray[i] == needleCharArray[j]) {
                i++;
                j++;
                next[i] = j;
            }else {
                j = next[j];
            }
        }
        
        return next;
    }
    
    /**
     * KMP解法
     * @param haystack
     * @param needle
     * @return
     */
    public int KMP(String haystack, String needle) {
        int[] next = getNext(needle.toCharArray());
        
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        char[] haystackCharArray = haystack.toCharArray();
        char[] needleCharArray = needle.toCharArray();
        
        int i = 0, j = 0;
        while(i < haystackLen && j < needleLen) {
            if(j == -1 || haystackCharArray[i] == needleCharArray[j]) {
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        if(j >= needleLen) {
            return i - needleLen;
        }
        return -1;
    }
    
    
    public int strStr(String haystack, String needle) {
        return KMP(haystack, needle);
    }
    
    public static void main(String[] args) {
        String haystack = "ababababca", needle = "aaabaaabaaababa";
        
        LeetCode28 leetCode28 = new LeetCode28();
        int index = leetCode28.strStr(haystack, needle);
        
        System.out.println(index);
    }
}
