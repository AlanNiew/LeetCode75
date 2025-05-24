package oneQuestionPerDay;

import java.util.Arrays;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2025/5/7 22:28
 */
public class Lt_1043 {


    class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int n = arr.length;
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int maxVal = 0;
                for (int j = i - 1; j >= i - k && j >= 0; j--) {
                    maxVal = Math.max(maxVal, arr[j]);
                    dp[i] = Math.max(dp[i], dp[j] + maxVal * k);
                }
                System.out.println(Arrays.toString(dp));
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }
            return dp[n];
        }
    }
}
