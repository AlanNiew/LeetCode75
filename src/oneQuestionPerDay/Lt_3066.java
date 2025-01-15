package oneQuestionPerDay;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2025/1/15 18:31
 */
public class Lt_3066 {

    class Solution {
        public int minOperations(int[] nums, int k) {
            //优先队列
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int num : nums) {
                if (num < k)
                    pq.offer((long) num);
            }
            int count = 0;
            while (pq.size() >= 2 && pq.peek() < k){
                long l = fun(pq.poll(), pq.poll());
                if (l < k){
                    pq.offer(l);
                }
                count++;
            }
            return count + pq.size();
        }

        private long fun(long a, long b){
            return Math.min(a, b) * 2L + Math.max(a, b);
        }

    }
}
