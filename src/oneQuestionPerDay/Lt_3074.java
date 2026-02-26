package oneQuestionPerDay;

import java.util.Arrays;

/**
 * @author Niu
 * @date 2025-12-24
 */
public class Lt_3074 {

    public static void main(String[] args) {
        int[] apple = {1, 3, 2};
        int[] capacity = {4,3,1,5,2};
        System.out.println(new Lt_3074().minimumBoxes(apple, capacity));
    }

    public int minimumBoxes(int[] apple, int[] capacity) {
        //计算苹果总数
        int appleSum = 0;
        for (int j : apple) {
            appleSum += j;
        }
        
        // 使用计数排序优化 - 当capacity值范围不大时更高效
        int maxCapacity = 0;
        for (int cap : capacity) {
            maxCapacity = Math.max(maxCapacity, cap);
        }
        
        // 计数数组
        int[] count = new int[maxCapacity + 1];
        for (int cap : capacity) {
            count[cap]++;
        }
        
        // 从大到小重新填充capacity数组
        int idx = capacity.length - 1;
        for (int cap = maxCapacity; cap >= 0; cap--) {
            while (count[cap] > 0) {
                capacity[idx--] = cap;
                count[cap]--;
            }
        }
        
        // 选择最少的箱子
        int boxNum = 0;
        int i = capacity.length - 1;
        while (i >= 0 && appleSum > 0) {
            appleSum -= capacity[i];
            boxNum++;
            i--;
        }
        
        return boxNum;
    }

}
