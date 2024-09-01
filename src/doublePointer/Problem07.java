package doublePointer;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/4 21:35
 */
public class Problem07 {

    public static void main(String[] args) {

    }

    /**
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     * 不使用除法，时间复杂度：O(n)
     * 左前缀乘积，有后缀乘积
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int[] leftArr = new int[len];
        int[] rightArr = new int[len];
        leftArr[0] = 1;
        rightArr[len - 1] = 1;
        for (int i = 1,j= len - 2,k = 0; i < len; i++,j--,k++) {
            int a = leftArr[i-1];
            int b = rightArr[j+1];
            int n1 = nums[k];
            int n2 = nums[len - 1 - k];
            leftArr[i] = a*n1;
            rightArr[j] = b*n2;
        }
        for (int i = 0; i < len; i++) {
            ans[i] = leftArr[i] * rightArr[i];
        }
        return ans;
    }
}
