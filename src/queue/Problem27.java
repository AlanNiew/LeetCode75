package queue;

import java.util.*;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/26 19:32
 */
public class Problem27 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            queue.offer(i);
        }
        System.out.println(queue);
    }

    static class RecentCounter {
        //队列
        Queue<Integer> queue;
        public RecentCounter() {
            queue = new LinkedList<>();
        }
        public int ping(int t) {
            int start = t - 3000;
            int size = queue.size(), count = 0;
            while (!queue.isEmpty() && (queue.peek() < start) ){
                queue.poll();
                count++;
            }
            queue.offer(t);
            return size - count + 1;
        }
    }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
}
