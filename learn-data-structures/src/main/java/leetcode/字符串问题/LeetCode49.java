package leetcode.字符串问题;

import java.util.*;

/**
 * @author: yeguxin
 * @date: 2020/12/14
 * @description:
 */
public class LeetCode49 {
    public static void main(String[] args) {
        String[] strList = {"eat", "tea", "tan", "ate", "nat", "bat"};
        
        LeetCode49 leetCode49 = new LeetCode49();
        leetCode49.groupAnagrams2(strList);
        
        System.out.println("Success");
    }
    
    
    /**
     * 字符串内部排序
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> strList = Arrays.asList(strs);
        
        Map<String, List<String>> flag = new HashMap<>();
        for(String str : strList) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String ss = new String(array);
            if(flag.get(ss) != null) {
                flag.get(ss).add(str);
            }else {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(str);
                flag.put(ss, arrayList);
            }
        }
        List<List<String>> result = new ArrayList<>();
        flag.keySet().stream().forEach(s -> {
            result.add(flag.get(s));
            System.out.println(flag.get(s));
        });
        return result;
    }
    
    /**
     * 质数相乘.
     * 每一个合数都可以写成2个以上质数相乘的结果
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Integer mod = Integer.MAX_VALUE;
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        Map<Integer, List<String>> resultMap = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            Integer num = 1;
            char[] charArray = strs[i].toCharArray();
            for(int j=0;j<charArray.length;j++){
                num = num * prime[charArray[j]-'a'] % mod;
            }
            if(resultMap.get(num) == null){
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(strs[i]);
                resultMap.put(num,arrayList);
            }else{
                resultMap.get(num).add(strs[i]);
            }
        }
        List<List<String>> result = new ArrayList<>();
        resultMap.keySet().stream().forEach(s -> {
            result.add(resultMap.get(s));
            System.out.println(resultMap.get(s));
        });
        return result;
        
    }
}
