package priority_queue;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Niu
 * @date 2026-03-11
 */
public class Problem50_Lt2336 {
    class SmallestInfiniteSet {

        // 当前无限集的最小值
        private int index;
        // 存储被添加回来的数字（都 < index）
        private PriorityQueue<Integer> pq;
        // 用于去重，判断数字是否已在队列中
        private Set<Integer> inQueue;

        public SmallestInfiniteSet() {
            index = 1;
            pq = new PriorityQueue<>();
            inQueue = new HashSet<>();
        }

        public int popSmallest() {
            // 如果队列不为空且队首 < index，说明有被 addBack 回来的更小数
            if (!pq.isEmpty() && pq.peek() < index) {
                int result = pq.poll();
                inQueue.remove(result);
                return result;
            }
            // 否则返回 index 并向后移动
            return index++;
        }

        public void addBack(int num) {
            // 只有当 num < index 且不在队列中时才添加
            // num >= index 说明该数字还在无限集中，无需添加
            if (num < index && !inQueue.contains(num)) {
                pq.offer(num);
                inQueue.add(num);
            }
        }
    }

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
}
