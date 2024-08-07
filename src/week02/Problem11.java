package week02;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/7 21:53
 */
public class Problem11 {

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
