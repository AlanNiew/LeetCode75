package dp;

import java.util.Arrays;

/**
 * @author Niu
 * @date 2026-05-08
 */
public class Problem64_Lt1143 {
    public static void main(String[] args) {
        System.out.println(new Problem64_Lt1143().longestCommonSubsequence("abcde", "ace"));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[m][n];
    }
}
