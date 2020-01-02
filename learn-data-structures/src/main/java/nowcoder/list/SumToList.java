package nowcoder.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: yeguxin
 * @date: 2019/12/30
 * @description: 和为S的连续正数序列
 */
public class SumToList {
    private static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    
    public static void main(String[] args) {
        SumToList sumToList = new SumToList();
        ArrayList<ArrayList<Integer>> arrayLists = sumToList.FindContinuousSequence(10);
        System.out.println("结束");
    }
    
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        SumToList sumToList = new SumToList();
        sumToList.calculate(sum,sum,1,new ArrayList<Integer>());
        return result;
    }
    
    public void calculate(int sum,int all,int num,ArrayList<Integer> list){
        for(int i=num;i<=sum;i++){
            list.add(i);
            if(sum-i <=0){
                if(sum - i == 0 && list.size() >1){
                    result.add(new ArrayList<>(list));
                }
                Iterator<Integer> iterator = list.iterator();
                while(iterator.hasNext()){
                    Integer next = iterator.next();
                    if(next.equals(i)){
                        iterator.remove();
                    }
                }
                return;
            }
            if(sum - 2*i -1 >=0){
                calculate(sum-i,all,i+1,list);
            }
            Iterator<Integer> iterator = list.iterator();
            while(iterator.hasNext()){
                Integer next = iterator.next();
                if(next.equals(i)){
                    iterator.remove();
                }
            }
        }
    }
}
