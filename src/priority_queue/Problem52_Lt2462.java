package priority_queue;

import java.util.PriorityQueue;

/**
 * LeetCode 2462. 雇佣 K 位工人的总成本
 *
 * 题目描述：
 * 给你一个下标从 0 开始的整数数组 costs，其中 costs[i] 是雇佣第 i 位工人的代价。
 * 同时给你两个整数 k 和 candidates。
 *
 * 我们想根据以下规则恰好雇佣 k 位工人：
 * 1. 最多进行 k 轮雇佣，且每一轮恰好雇佣一位工人。
 * 2. 在每一轮雇佣中，从最前面 candidates 和最后面 candidates 中选出代价最小的一位工人。
 *    如果最前面和最后面有多位工人代价相同，优先选择下标较小的那位。
 * 3. 选中的工人从数组中移除。
 *
 * 返回雇佣恰好 k 位工人的总代价。
 *
 * 解题思路：
 * 使用双优先队列策略：
 * - leftPQ 维护数组左侧 candidates 个工人
 * - rightPQ 维护数组右侧 candidates 个工人
 * - 每轮选择两堆中代价最小的，并从未选中区域补充新工人
 *
 * 时间复杂度：O(n + k × log n)
 * 空间复杂度：O(n)
 *
 * @author Niu
 * @date 2026-03-11
 */
public class Problem52_Lt2462 {
    public static void main(String[] args) {
        Problem52_Lt2462 solution = new Problem52_Lt2462();

        // 测试用例1
        int[] costs1 = {31, 25, 72, 79, 74, 65, 84, 91, 18, 59, 27, 9, 81, 33, 17, 58};
        System.out.println("测试1: " + solution.totalCost(costs1, 11, 2)); // 期望: 423

        // 测试用例2
        int[] costs2 = {17, 12, 10, 2, 7, 2, 11, 20, 8};
        System.out.println("测试2: " + solution.totalCost(costs2, 3, 4)); // 期望: 11

        // 测试用例3
        int[] costs3 = {1, 2, 4, 1};
        System.out.println("测试3: " + solution.totalCost(costs3, 3, 3)); // 期望: 4

        // 大数据量测试
        int[] large = new int[100000];
        for (int i = 0; i < 100000; i++) {
            large[i] = 100000 - i;
        }
        long start = System.currentTimeMillis();
        System.out.println("大数据测试: " + solution.totalCost(large, 50000, 500));
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + "ms");
    }

    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;

        // 左侧优先队列（小顶堆）：存储前 candidates 个工人的代价
        PriorityQueue<Integer> leftPQ = new PriorityQueue<>();
        // 右侧优先队列（小顶堆）：存储后 candidates 个工人的代价
        PriorityQueue<Integer> rightPQ = new PriorityQueue<>();

        // 左右指针，标记未处理的区间
        int left = 0;
        int right = n - 1;

        long totalCost = 0;

        // 进行 k 轮雇佣
        for (int round = 0; round < k; round++) {
            // 补充左侧候选人（保持 candidates 个）
            while (leftPQ.size() < candidates && left <= right) {
                leftPQ.offer(costs[left]);
                left++;
            }

            // 补充右侧候选人（保持 candidates 个）
            while (rightPQ.size() < candidates && left <= right) {
                rightPQ.offer(costs[right]);
                right--;
            }

            // 获取两侧的最小代价（如果队列为空，设为最大值）
            int leftMin = leftPQ.isEmpty() ? Integer.MAX_VALUE : leftPQ.peek();
            int rightMin = rightPQ.isEmpty() ? Integer.MAX_VALUE : rightPQ.peek();

            // 选择代价较小的一侧；如果相等，优先选左侧（下标更小）
            if (leftMin <= rightMin && !leftPQ.isEmpty()) {
                totalCost += leftPQ.poll();
            } else if(!rightPQ.isEmpty()) {
                totalCost += rightPQ.poll();
            }
        }

        return totalCost;
    }
}
