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
}
class RecentCounter {

    Queue<Integer> queue;
    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        int begin = t - 3000;
        while (!queue.isEmpty() && queue.peek() < begin)queue.poll();
        queue.offer(begin);
        return queue.size();
    }


}