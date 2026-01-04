package oneQuestionPerDay;

/**
 * @author Niu
 * @date 2026-01-03
 */
public class Lt_3788 {
    public static void main(String[] args) {
        Lt_3788 lt_3788 = new Lt_3788();
        System.out.println(lt_3788.maximumScore(new int[]{1,1000000000}));
    }
    /**
     * 3788. 最大得分
     * @param nums 数组
     * @return 最大得分
     *
     * 思路：
     * 1. 创建一个二维数组，用于保存每个数字的得分
     * 2. 遍历数组，计算每个数字的得分
     * 3. 返回最大得分
     */
    public long maximumScore(int[] nums) {
        int n = nums.length;
        long[] suffixMin = new long[n+1];
        // 左侧和分数最大，右侧最小分数
        suffixMin[n] = 1_000_000_000+1;
        for (int i = n - 1; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i+1], nums[i]);
        }
        long prefixSum = 0;
        long max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            prefixSum = prefixSum + nums[i-1];
            long score = prefixSum - suffixMin[i];
            max = Math.max(max, score);
        }
        return max;
    }
}
