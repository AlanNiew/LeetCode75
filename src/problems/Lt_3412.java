package problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2025/1/5 16:43
 */
public class Lt_3412 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "ikjvjyxvomnxccft";
        System.out.println(solution.calculateScore(str));
        System.out.println(str);
        for (char c : str.toCharArray()) {
            System.out.print(solution.mirrorChar(c));
        }
    }

    private static class Solution {
        public long calculateScore(String s) {
            int len = s.length();
            char[] chars = s.toCharArray();
            long score = 0;
            Map<Character, Stack<Integer>> map = new HashMap<>(26);
            for (int i = 0; i < len; i++) {
                char c = chars[i];
                char mirrorChar = mirrorChar(c);
                Stack<Integer> stack = map.getOrDefault(mirrorChar, new Stack<>());
                //如果未找到对应的标记，则存进去
                if (stack.isEmpty()){
                    Stack<Integer> stack1 = map.getOrDefault(c, new Stack<>());
                    stack1.push(i);
                    map.put(c, stack1);
                }else {
                    //不为空弹出第一个
                    int j = stack.pop();
                    score += i - j;
                }
            }
            return score;
        }
        private char mirrorChar(char c){
            return (char) ('z' - (c - 'a'));
        }
    }
}
