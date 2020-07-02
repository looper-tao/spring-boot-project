package leetcode.其他;

/**
 * @author: yeguxin
 * @date: 2020/7/2
 * @description:
 *
 * 125. 验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 */
public class LeetCode125 {
    
    public boolean isPalindrome(String s) {
        char[] toCharArray = s.toCharArray();
        
        int len = toCharArray.length;
        int index = 0;
        for(int i=0;i<len;i++){
            if((toCharArray[i] >='A' && toCharArray[i] <= 'Z') || (toCharArray[i] >='a' && toCharArray[i] <= 'z')|| (toCharArray[i] >='0' && toCharArray[i] <= '9')){
                if(toCharArray[i] >='A' && toCharArray[i] <= 'Z'){
                    toCharArray[index++] = (char) (toCharArray[i]+32);
                }else{
                    toCharArray[index++] = toCharArray[i];
                }
            }
        }
        
        for(int i=0;i<index/2;i++){
            if(toCharArray[i] != toCharArray[index-1-i]){
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String str = "0P";
        
        LeetCode125 leetCode125 = new LeetCode125();
    
        boolean result = leetCode125.isPalindrome(str);
        
        System.out.println(result);
    }
}
