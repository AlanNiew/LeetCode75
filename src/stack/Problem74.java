package stack;

import java.util.Collections;
import java.util.Stack;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2025/1/23 19:08
 */
public class Problem74 {
    public static void main(String[] args) {
        new Solution().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
   static class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int length = temperatures.length;
            int [] res = new int[length];
            Stack<Integer> indexStack = new Stack<>();
            for (int i = 0; i < length; i++) {
                int temperature = temperatures[i];
                //维护递减单调栈
                while (!indexStack.isEmpty()){
                    if (temperature> temperatures[indexStack.peek()]) {
                        Integer index = indexStack.pop();
                        res[index] = i - index;
                    }else {
                        break;
                    }
                }
                indexStack.push(i);
            }
            return res;
        }
    }
}
