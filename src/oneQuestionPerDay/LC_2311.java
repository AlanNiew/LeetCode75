package oneQuestionPerDay;

import java.util.Arrays;

/**
 * @author Niu
 * @date 2025-06-26
 */

public class LC_2311 {

    public static void main(String[] args) {
        System.out.println(new LC_2311().longestSubsequence("00101001", 1));
    }

    public int longestSubsequence(String s, int k) {
        int len = s.length();
        char[] charArray = s.toCharArray();
        int [] zero = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            if (charArray[i - 1] == '0'){
                zero[i] = zero[i - 1] + 1;
            }else{
                zero[i] = zero[i - 1];
            }
        }
        System.out.println(Arrays.toString(zero));
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                String s1 = String.valueOf(charArray, i, j - i);
                int n = Integer.parseInt(s1, 2);
                if (n <= k){
                    int l = (j - i) + zero[i + 1];
                    max = Math.max(max, l);
                }
            }
        }
        return max;
    }
}
