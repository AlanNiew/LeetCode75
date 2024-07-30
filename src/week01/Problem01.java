package week01;

import java.util.StringJoiner;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/7/30 21:05
 */
public class Problem01 {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr112"));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int len = Math.max(len1, len2);
        int index = 0;
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        while (index < len){
            if (index < len1){
                res.append(chars1[index]);
            }else {
                res.append(word2.substring(index));
                break;
            }
            if (index < len2){
                res.append(chars2[index]);
            }else {
                res.append(word1.substring(index));
                break;
            }
            index++;
        }
        return res.toString();
    }
}
