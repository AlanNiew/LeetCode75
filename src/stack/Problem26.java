package stack;

import java.util.Stack;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/26 18:51
 */
public class Problem26 {

    public static void main(String[] args) {
        String s = new Solution().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
        System.out.println(s);
    }


    static class Solution {
        public String decodeString(String s) {
            Stack<StringBuilder> stack = new Stack<>();
            Stack<Integer> stack1 = new Stack<>();
            char[] chars = s.toCharArray();
            int n = 0;
            for (char aChar : chars) {
                if (aChar <= '9') {
                    //开始记录数字
                    n = n * 10 + aChar - '0';
                }else {
                    if (aChar == ']') {
                        //开始弹出
                        StringBuilder pop,sb = new StringBuilder();
                        while (!stack.isEmpty() && !(pop = stack.pop()).toString().equals("[")) {
                            //如果是字符串进入要反转
                            sb.append(pop.reverse());
                        }
                        stack.push(new StringBuilder(sb.reverse().toString().repeat(stack1.pop())));
                    } else {
                        stack.push(new StringBuilder(String.valueOf(aChar)));//放入
                        //数字入栈,并重新记录
                        if (aChar == '['){
                            stack1.push(n);
                            n = 0;
                        }
                    }
                }
            }
            StringBuilder res = new StringBuilder();
            while (!stack.isEmpty()) {
                res.insert(0,stack.pop());
            }
            return res.toString();
        }
    }

    /**
     * 394. 字符串解码
     * @param s
     * @return
     */
    public static String decodeString(String s) {
        char[] chars = s.toCharArray();
        Stack<String> stack  = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        StringBuilder numStr = new StringBuilder();
        int stackFlag = 0; //开启入栈标志
        for (char aChar : chars) {
            if(isNum(aChar)) {
                numStr.append(aChar);
                continue;
            } else if (numStr.length() > 0) {
                int num = Integer.parseInt(numStr.toString());
                numStack.push(num);
                numStr = new StringBuilder();
            }
            //---------处理栈信息----------
            if (aChar == '[') {
                stackFlag ++;
            }
            if (stackFlag == 0){
                res.append(aChar);
            }
            if (stackFlag > 0){
                if (aChar == ']') {
                    StringBuilder tmp = new StringBuilder();
                    while (!stack.isEmpty()) {
                        String pop = stack.pop();
                        if (pop.equals("["))break;
                        if (pop.length()>1){
                            pop = reverse(pop);
                        }
                        tmp.append(pop);
                    }
                    tmp.reverse();
                    stackFlag --;
                    Integer pop = numStack.pop();
                    StringBuilder tmpStr = new StringBuilder();
                    for (int i = 0; i < pop; i++) {
                        tmpStr.append(tmp);
                    }
                    stack.push(tmpStr.toString());
                    if (stackFlag == 0){
                        res.append(tmpStr);
                    }
                }else{
                    stack.push(String.valueOf(aChar));
                }
            }
        }

        return res.toString();
    }
    //判断一个字符是否是数字
    public static boolean isNum(char c){
        return c >= '0' && c <= '9';
    }

    //反转字符串
    public static String reverse(String s){
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right){
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left ++;
            right --;
        }
        return new String(chars);
    }
}
