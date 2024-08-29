package weekContest412;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/25 10:48
 */
public class C {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int len = nums.length;
        long[] longValues = new long[len];
        for (int i = 0; i < len; i++) {
            longValues[i] = nums[i];
        }

        // 维护一个双端队列，用于存储窗口内元素的索引
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int min = Math.min(k, len);
        // 初始化窗口
        for (int i = 0; i < min; i++) {
            while (!deque.isEmpty() && longValues[deque.peekLast()] >= longValues[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        // 更新最小值
        for (int i = min; i < len; i++) {
            int minIndex = deque.peekFirst();
            longValues[minIndex] = (longValues[minIndex] * multiplier) % 1000000007;

            // 移除窗口外的元素
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }

            // 移除大于当前元素的元素
            while (!deque.isEmpty() && longValues[deque.peekLast()] >= longValues[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        // 处理最后一个窗口
        int minIndex = deque.peekFirst();
        longValues[minIndex] = (longValues[minIndex] * multiplier) % 1000000007;

        for (int i = 0; i < len; i++) {
            nums[i] = (int)longValues[i] % 1000000007;
        }
        return nums;
    }

    // 快速幂计算
    private long power(int base, long exponent) {
        long result = 1;
        long b = base % 1000000007;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * b) % 1000000007;
            }
            exponent >>= 1;
            b = (b * b) % 1000000007;
        }
        return result;
    }


    public static int[] getFinalState(int[] nums, long k, int multiplier) {
        int len = nums.length;
        long[] longValues = new long[len];
        for (int i = 0; i < len; i++) {
            longValues[i] = nums[i];
        }

        // 维护一个双端队列，用于存储窗口内元素的索引
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // 初始化窗口
        int min = (int) Math.min(k, len);
        for (int i = 0; i < min; i++) {
            while (!deque.isEmpty() && longValues[deque.peekLast()] >= longValues[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        // 更新最小值
        for (int i = 0; i < len; i++) {
            int minIndex = deque.peekFirst();
            if (longValues[minIndex] != nums[minIndex]) {
                deque.removeFirst();
            } else {
                longValues[minIndex] = (longValues[minIndex] * multiplier) % 1000000007;
            }

            // 移除窗口外的元素
            while (!deque.isEmpty() && deque.peekFirst() <= i - min) {
                deque.removeFirst();
            }

            // 移除大于当前元素的元素
            while (!deque.isEmpty() && longValues[deque.peekLast()] >= longValues[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        // 处理最后一个窗口
        int minIndex = deque.peekFirst();
        if (longValues[minIndex] == nums[minIndex]) {
            longValues[minIndex] = (longValues[minIndex] * multiplier) % 1000000007;
        }
        // 返回结果
        for (int i = 0; i < len; i++) {
            nums[i] = (int)longValues[i] % 1000000007;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 6};
        long k = 5;
        int multiplier = 2;

        int[] result = getFinalState(nums, k, multiplier);
        System.out.println(Arrays.toString(result));
    }


}
