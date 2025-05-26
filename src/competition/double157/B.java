package competition.double157;

import java.util.Arrays;

/**
 * @Author: Niu
 * @Date: 2025/5/25 09:21
 * @Description:
 */
public class B {
    public static void main(String[] args) {
        System.out.println(new B().maxSubstrings("aaaeaaa"));
    }

    public int maxSubstrings(String word) {
        int n = word.length();
        int[] dp = new int[n + 1];
        for (int i = n - 1 ; i >=0 ; i--) {
            dp[i] = dp[i + 1];
            for (int j = i + 3; j < n; j++) {
                if (word.charAt(i) == word.charAt(j)){
                    dp[i] = Math.max(dp[i],dp[j+1] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}
