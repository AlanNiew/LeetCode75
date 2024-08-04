package week01;

import java.util.Arrays;
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
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U'));
        int left = 0;
        int right = chars.length - 1;
        while (left < right){
            while (left < right && !set.contains(chars[left])) left++;
            while (left < right && !set.contains(chars[right])) right--;
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
        return new String(chars);
    }

}
