package dp;

/**
 * @author Niu
 * @date 2026-05-09
 */
public class Problem66_Lt72 {
    public static void main(String[] args) {
        System.out.println(new Problem66_Lt72().minDistance("intention", "execution"));
    }
    public int minDistance(String word1, String word2) {
        // 有几个相同的
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 行
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i-1][0] +1;
        }
        //列
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = dp[0][i-1] +1;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
