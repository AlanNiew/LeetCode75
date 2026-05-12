package oneQuestionPerDay;

/**
 * @author Niu
 * @date 2026-05-01
 */
public class Lt_396 {
    public int maxRotateFunction(int[] nums) {
        long max = Integer.MIN_VALUE;
        //旋转数组
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            // 1
            for (int j = i; j < n; j++) {
                sum+= (long) (j) * nums[j];
            }
            max = Math.max(max,sum);
        }
        return Math.toIntExact(max);
    }
}
