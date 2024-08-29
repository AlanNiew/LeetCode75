package oneQuestionPerDay;

import java.util.Map;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/24 20:36
 */
public class LC_3146 {

    public static void main(String[] args) {
        char a = 'a';
        System.out.println(a);
        System.out.println((int)a);
        System.out.println(new LC_3146().findPermutationDifference("abcd", "cdab"));
    }
    public int findPermutationDifference(String s, String t) {
        int [] arrIndex = new int[26];
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        int res = 0;
        int a = 'a';
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            arrIndex[aChar - a] = i;
        }
        for (int i = 0; i < chars1.length; i++) {
            char c = chars1[i];
            int index = arrIndex[c - a];
            res += abs(i - index);
        }
        return res;
    }

    private int abs(int n){
        return n > 0 ? n : -n;
    }

}
