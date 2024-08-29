package week05;

import java.util.Stack;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/25 10:17
 */
public class Problem24 {

    /**
     * 2390. 删除 stars 后的结果字符串
     * 思路：单调栈
     * @param s
     * @return
     */
    public String removeStars(String s) {
        StringBuilder str = new StringBuilder();
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (aChar!='*'){
                stack.push(aChar);
            }else {
                stack.pop();
            }
        }
        while (!stack.isEmpty()){
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}
