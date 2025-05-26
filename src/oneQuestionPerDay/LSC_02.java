package oneQuestionPerDay;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Niu
 * @Date: 2025/5/26 13:16
 * @Description:
 */
public class LSC_02 {
    public static void main(String[] args) {
        System.out.println(new LSC_02().halfQuestions(new int[]{2,2,6,1}));
    }
    public int halfQuestions(int[] questions) {
        int max = 0;
        int n = questions.length / 2;
        Arrays.sort(questions);
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < questions.length && n>0; i++) {
            int count = 1;
            while (i + 1 < questions.length && questions[i] == questions[i + 1]) {
                count++;
                i++;
            }
            if (count >= n) {
                return 1;
            }
            pq.offer(count);
        }
        while (!pq.isEmpty() && n > 0) {
            int num = pq.poll();
            n -= num;
            max++;
        }
        return max;
    }
}
