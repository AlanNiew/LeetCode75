package binarySearch;

/**
 * @author Niu
 * @date 2026-03-17
 */
public class Problem55_Lt162 {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int ans = 0;
        int max = -1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1] && i < len - 1 && nums[i] > nums[i + 1]) {
                return i;
            }
            if (nums[i]>max){
                max = nums[i];
                ans = i;
            }
        }
        return ans;
    }
}
