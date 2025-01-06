package arrAndString;

import java.util.*;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/4 9:25
 */
public class Problem05 {

    class Solution {
        public String reverseVowels(String s) {
            //反转元音，记录下标，重排回去
            char[] chars = s.toCharArray();
            Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U'));
            Stack<Integer> stack = new Stack<>();
            List<Character> list = new LinkedList<>();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (set.contains(c)){
                    stack.push(i);
                    list.add(c);
                }
            }
            while (!stack.isEmpty()){
                chars[stack.pop()] = list.remove(0);
            }
            return new String(chars);
        }
    }

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
