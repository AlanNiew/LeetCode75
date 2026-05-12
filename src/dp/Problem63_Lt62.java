package dp;

import java.util.Arrays;

/**
 * @author Niu
 * @date 2026-05-08
 */
public class Problem63_Lt62 {
    public static void main(String[] args) {
        System.out.println(new Problem63_Lt62().uniquePaths(2, 3));
    }
    // m行 和 n列
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        System.out.println("---------");
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[m-1][n-1];
    }

}
