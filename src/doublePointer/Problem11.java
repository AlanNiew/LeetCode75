package doublePointer;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/7 21:53
 */
public class Problem11 {


    static class Solution {
        public boolean isSubsequence(String s, String t) {
            int len1 = s.length(), len2 = t.length();
            int left = 0,right = 0;
            if (len1 == 0) return true;
            if (len1 > len2) return false;
            if (len1 == len2) return s.equals(t);
            char[] chars1 = s.toCharArray();
            char[] chars2 = t.toCharArray();
            while (left < len1 && right < len2) {
                if (chars1[left] == chars2[right]) {
                    left++;
                }
                right++;
            }
            return left == len1;
        }
    }

    /**
     * 392. 判断子序列 ，s是否为t的子串
     */
    public boolean isSubsequence(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int index = 0;
        int cur = 0;
        while (cur < chars2.length && index < chars1.length) {
            if (chars2[cur++]==chars1[index])index++;
        }
        return index == chars1.length;
    }
}
