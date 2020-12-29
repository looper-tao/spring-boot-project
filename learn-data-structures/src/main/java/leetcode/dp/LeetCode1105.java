package leetcode.dp;

/**
 * @author: yeguxin
 * @date: 2020/12/23
 * @description:
 */
public class LeetCode1105 {
    public static void main(String[] args) {
        int[][] books = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        LeetCode1105 leetCode1105 = new LeetCode1105();
        int result = leetCode1105.minHeightShelves(books, 4);
        System.out.println(result);
    }
    
    /**
     *
     * @param books
     * @param shelf_width
     * @return
     */
    public int minHeightShelves(int[][] books, int shelf_width) {
        int[][] dp = new int[books.length][books.length];
        for(int i = 0; i < books.length; i++) {
            for(int j = 0; j < books.length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i < books.length; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=0;j<i;j++){
                min = min < dp[j][i-1] ? min : dp[j][i-1];
            }
            int sum = 0, max = 0;
            for(int j = i; j < books.length; j++) {
                int width = books[j][0];
                int height = books[j][1];
                
                if((sum + width) <= shelf_width) {
                    sum += width;
                    max = max < height ? height : max;
                }else{
                    break;
                }
                min = (min == Integer.MAX_VALUE) ? 0 : min;
                dp[i][j] = max + min;
            }
            System.out.println();
        }
        int minResult = Integer.MAX_VALUE;
        for(int i=0;i<books.length;i++){
            minResult = minResult > dp[i][books.length-1] ? dp[i][books.length-1] : minResult;
        }
        return minResult;
    }
}
