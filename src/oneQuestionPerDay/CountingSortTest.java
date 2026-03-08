package oneQuestionPerDay;

/**
 * 计数排序测试类
 */
public class CountingSortTest {
    
    public static void main(String[] args) {
        // 测试用例1：基本功能测试
        int[] test1 = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("原数组: " + java.util.Arrays.toString(test1));
        
        int[] sorted1 = CountingSortUtil.countingSort(test1.clone());
        System.out.println("排序后: " + java.util.Arrays.toString(sorted1));
        
        // 测试用例2：包含负数
        int[] test2 = {-5, -1, 0, 3, -2, 4, 1};
        System.out.println("\n原数组(含负数): " + java.util.Arrays.toString(test2));
        
        int[] sorted2 = CountingSortUtil.countingSort(test2.clone());
        System.out.println("排序后: " + java.util.Arrays.toString(sorted2));
        
        // 测试用例3：相同元素
        int[] test3 = {5, 5, 5, 5};
        System.out.println("\n原数组(相同元素): " + java.util.Arrays.toString(test3));
        
        int[] sorted3 = CountingSortUtil.countingSort(test3.clone());
        System.out.println("排序后: " + java.util.Arrays.toString(sorted3));
        
        // 测试用例4：单个元素
        int[] test4 = {42};
        System.out.println("\n原数组(单个元素): " + java.util.Arrays.toString(test4));
        
        int[] sorted4 = CountingSortUtil.countingSort(test4.clone());
        System.out.println("排序后: " + java.util.Arrays.toString(sorted4));
        
        // 性能对比测试
        System.out.println("\n性能对比测试:");
        int[] largeArray = new int[100000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = (int)(Math.random() * 1000); // 范围在0-999之间
        }
        
        // 测试计数排序性能
        int[] countingSortArray = largeArray.clone();
        long startTime = System.nanoTime();
        CountingSortUtil.countingSortInPlace(countingSortArray);
        long countingSortTime = System.nanoTime() - startTime;
        
        // 测试Arrays.sort性能
        int[] arraySortArray = largeArray.clone();
        startTime = System.nanoTime();
        java.util.Arrays.sort(arraySortArray);
        long arraySortTime = System.nanoTime() - startTime;
        
        System.out.println("计数排序耗时: " + countingSortTime / 1000000.0 + " ms");
        System.out.println("Arrays.sort耗时: " + arraySortTime / 1000000.0 + " ms");
        
        // 验证两种排序结果是否一致
        boolean isEqual = java.util.Arrays.equals(countingSortArray, arraySortArray);
        System.out.println("排序结果是否一致: " + isEqual);
    }
}