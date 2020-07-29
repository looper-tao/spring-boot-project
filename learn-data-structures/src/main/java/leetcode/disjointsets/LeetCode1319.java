package leetcode.disjointsets;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yeguxin
 * @date: 2020/7/29
 * @description:
 *
 * 1319. 连通网络的操作次数
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 *
 * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 *
 * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 4, connections = [[0,1],[0,2],[1,2]]
 * 输出：1
 * 解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
 * 示例 2：
 *
 *
 *
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * 输出：2
 * 示例 3：
 *
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * 输出：-1
 * 解释：线缆数量不足。
 * 示例 4：
 *
 * 输入：n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= n <= 10^5
 * 1 <= connections.length <= min(n*(n-1)/2, 10^5)
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] < n
 * connections[i][0] != connections[i][1]
 * 没有重复的连接。
 * 两台计算机不会通过多条线缆连接。
 */
public class LeetCode1319 {
    Map<Integer, Integer> unionMap = new HashMap<>();
    
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) {
            return -1;
        }
        for(int i = 0; i < n; i++) {
            unionMap.put(i, i);
        }
        for(int i = 0; i < connections.length; i++) {
            if(find(connections[i][0]).compareTo(find(connections[i][1])) == 0){
                continue;
            }
            union(connections[i][0], connections[i][1]);
        }
        return (int) unionMap.keySet().stream().filter(integer -> {
            return unionMap.get(integer).compareTo(integer) == 0;
        }).count() - 1;
    }
    
    public Integer find(Integer a) {
        if(unionMap.get(a).compareTo(a) == 0) {
            return a;
        }
        return find(unionMap.get(a));
    }
    
    public void union(Integer a, Integer b) {
        Integer va = find(a);
        Integer vb = find(b);
        if(va.compareTo(vb) == 0) {
            return;
        }
        if(va > vb){
           unionMap.put(va, vb);
        }else {
            unionMap.put(vb, va);
        }
       
    }
    
    public static void main(String[] args) {
        LeetCode1319 leetCode1319 = new LeetCode1319();
        int[][] connections = {{3,4},{5,6},{0,3},{0,5},{1,7},{0,4},{2,6},{1,6},{1,3},{3,7},{4,5},{3,5}};
        int result = leetCode1319.makeConnected(11, connections);
        System.out.println(result);
    }
}
