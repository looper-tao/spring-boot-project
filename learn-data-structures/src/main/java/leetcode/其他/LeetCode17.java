package leetcode.其他;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: yeguxin
 * @date: 2020/6/24
 * @description:
 */
public class LeetCode17 {
    char num[][] = {
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
    };
    
    List<String> strList = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        strList = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        Stack<Integer> stack = new Stack<>();
        int parseInt = Integer.parseInt(digits);
        while(parseInt > 0) {
            int num = parseInt % 10;
            stack.push(num);
            parseInt = parseInt / 10;
        }
        List<Integer> numList = new ArrayList<>();
        while(!stack.isEmpty()){
            numList.add(stack.pop());
        }
        dfs(numList,0,"");
        return strList;
        
    }
    
    public void dfs(List<Integer> numList,int index,String str){
        if(numList.size() == index){
            strList.add(str);
            return;
        }
        Integer integer = numList.get(index) -2;
        for(int i = 0;i<num[integer].length;i++){
            dfs(numList,index+1,str+num[integer][i]);
        }
    }
    
    public static void main(String[] args) {
//        letterCombinations("23");
//        strList.stream().forEach(System.out::println);
    }
}
