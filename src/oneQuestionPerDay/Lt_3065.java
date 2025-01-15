package oneQuestionPerDay;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2025/1/15 18:28
 */
public class Lt_3065 {

    class Solution {
        public int minOperations(int[] nums, int k) {
            int count = 0;
            for (int num : nums) {
                if (num<k){
                    count++;
                }
            }
            return count;
        }
    }
}
