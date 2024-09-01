package slidWindow;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/10 21:35
 */
public class Problem14 {
    /**
     * 643. 子数组最大平均数 I
     * k 为窗口大小
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int left = 0;
        int right = k;
        int max = sum;
        while (right < nums.length){
            sum = sum - nums[left++] + nums[right++];
            if ( sum > max){
                max = sum;
            }
        }
        return max*1.0/k;
    }
}
