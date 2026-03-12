package priority_queue;

import java.util.PriorityQueue;

/**
 * @author Niu
 * @date 2026-03-11
 */
public class Problem49_Lt215 {
    public static void main(String[] args) {
        Problem49_Lt215 solution = new Problem49_Lt215();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(solution.findKthLargest(nums, k));
    }
    public int findKthLargest(int[] nums, int k) {
        // 最小堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();

    }
}
