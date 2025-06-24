package dp;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2025/5/16 21:21
 */
public class Lt_746 {
    public static void main(String[] args) {
        int[] cost = {10,15,20};
        System.out.println(new Lt_746().minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int [] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            int p1 = cost[i] + dp[i - 2];
            int p2 = cost[i] + dp[i - 1];
            dp[i] = Math.min(p1, p2);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
}
