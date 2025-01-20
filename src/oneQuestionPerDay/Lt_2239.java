package oneQuestionPerDay;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2025/1/20 19:09
 */
public class Lt_2239 {
    class Solution {
        public int findClosestNumber(int[] nums) {
            int min = Integer.MAX_VALUE;
            int res = 0;
            for (int num : nums) {
                int abs = Math.abs(num);
                if (abs < min) {
                    min = abs;
                    res = num;
                } else if (abs == min) {
                    res = Math.max(res, num);
                }
            }
            return res;
        }
    }
}
