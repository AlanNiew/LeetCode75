package oneQuestionPerDay;

/**
 * 计数排序工具类
 * 适用于数值范围较小的整数数组排序
 */
public class CountingSortUtil {

    /**
     * 计数排序实现
     * 时间复杂度: O(n+k)，其中n是数组长度，k是数值范围
     * 空间复杂度: O(k)
     * 
     * @param arr 待排序的整数数组
     * @return 排序后的新数组
     */
    public static int[] countingSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        // 找到数组中的最大值和最小值，以确定计数数组的范围
        int max = arr[0];
        int min = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }

        // 计算计数数组的大小
        int range = max - min + 1;
        
        // 创建计数数组
        int[] count = new int[range];
        
        // 统计每个元素出现的次数
        for (int value : arr) {
            count[value - min]++;
        }
        
        // 重构排序后的数组
        int[] sortedArr = new int[arr.length];
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                sortedArr[index++] = i + min;
                count[i]--;
            }
        }
        
        return sortedArr;
    }

    /**
     * 原地计数排序（修改原数组）
     * 
     * @param arr 待排序的整数数组
     */
    public static void countingSortInPlace(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 找到数组中的最大值和最小值
        int max = arr[0];
        int min = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }

        // 计算计数数组的大小
        int range = max - min + 1;
        
        // 创建计数数组
        int[] count = new int[range];
        
        // 统计每个元素出现的次数
        for (int value : arr) {
            count[value - min]++;
        }
        
        // 将排序后的元素放回原数组
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                arr[index++] = i + min;
                count[i]--;
            }
        }
    }
}