package leetcode.disjointsets;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yeguxin
 * @date: 2020/7/27
 * @description:
 *
 * 面试题 17.07. 婴儿名字
 * 每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。有些名字有多种拼法，例如，John 和 Jon 本质上是相同的名字，但被当成了两个名字公布出来。给定两个列表，一个是名字及对应的频率，另一个是本质相同的名字对。设计一个算法打印出每个真实名字的实际频率。注意，如果 John 和 Jon 是相同的，并且 Jon 和 Johnny 相同，则 John 与
 * Johnny 也相同，即它们有传递和对称性。
 *
 * 在结果列表中，选择字典序最小的名字作为真实名字。
 *
 * 示例：
 *
 * 输入：names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"], synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
 * 输出：["John(27)","Chris(36)"]
 * 提示：
 *
 * names.length <= 100000
 */
public class LeetCodeBabyNamesLCCI {
    private Map<String, String> unionMap = new HashMap<>();
    private Map<String, Integer> countMap = new HashMap<>();
    
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        for(String str : names) {
            int idx1 = str.indexOf('(');
            int idx2 = str.indexOf(')');
            int frequency = Integer.valueOf(str.substring(idx1 + 1, idx2));
            String name = str.substring(0, idx1);
            countMap.put(name, frequency);
            unionMap.put(name, name);
            
        }
        for(String str : synonyms) {
            String[] s = str.replaceAll("[()]", "").split(",");
            String name1 = s[0];
            String name2 = s[1];
            union(name1,name2);
        }
        String[] result = new String[countMap.size()];
        int count = -1;
        for(String key:countMap.keySet()) {
            result[++count] = (key+"("+countMap.get(key)+")");
        }
        
        return result;
        
    }
    
    public String find(String name){
        if(unionMap.get(name) == null){
            unionMap.put(name,name);
            countMap.put(name,0);
            return name;
        }
        if(unionMap.get(name).equals(name)){
            return name;
        }
        return find(unionMap.get(name));
    }
    
    public void union(String name1,String name2){
        String unionName1 = find(name1);
        String unionName2 = find(name2);
        
        if(unionName1.equals(unionName2)){
            return;
        }
        
        if(unionName1.compareTo(unionName2) <0){
            unionMap.put(unionName2,unionName1);
            countMap.put(unionName1, countMap.get(unionName1) + countMap.get(unionName2));
            countMap.remove(unionName2);
        }else{
            unionMap.put(unionName1,unionName2);
            countMap.put(unionName2, countMap.get(unionName1) + countMap.get(unionName2));
            countMap.remove(unionName1);
        }
        
    }
    
    public static void main(String[] args) {
        String[] names = {"John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"};
        String[] synonyms = {"(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"};
        LeetCodeBabyNamesLCCI leetCodeBabyNamesLCCI = new LeetCodeBabyNamesLCCI();
        leetCodeBabyNamesLCCI.trulyMostPopular(names,synonyms);
    
        
    }
}
