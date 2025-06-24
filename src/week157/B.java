package week157;

import java.util.*;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2025/5/24 22:46
 */
public class B {

    public static void main(String[] args) {
        System.out.println(new B().maxSubstrings("aabececbbeccdcdcbbdece"));
    }
    // 首尾字母相同 且 长度至少为 4 的 不相交子字符串 的最大数量
    public int maxSubstrings(String word) {
        int n = word.length();
        int[] dp = new int[n + 1]; // dp[i] 表示从 i 开始能选的最大合法子串数

        for (int i = n-1; i >= 0; i--) {
            char startChar = word.charAt(i);
            for (int j = i + 3; j < n; j++) { // 确保长度 >= 4
                if (word.charAt(j) == startChar) {
                    dp[i] = Math.max(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
    }
}
