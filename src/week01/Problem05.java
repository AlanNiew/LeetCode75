package week01;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/4 9:25
 */
public class Problem05 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int [] indexArr = new int[length];
        int len = 0;
        for (int i = 0; i < length; i++) {
            if (set.contains(chars[i])){
                indexArr[len++] = i;
            }
        }
        for (int i = 0; i < len / 2; i++) {
            int last = len - i - 1;
            char tmp = chars[indexArr[i]];
            chars[indexArr[i]] = chars[indexArr[last]];
            chars[indexArr[last]] = tmp;
        }
        return new String(chars);
    }
}
