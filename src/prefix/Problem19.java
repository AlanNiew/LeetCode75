package prefix;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/20 20:30
 */
public class Problem19 {
    public static void main(String[] args) {
        System.out.println(new Solution().pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    static class Solution {
        public int pivotIndex(int[] nums) {
            int length = nums.length;
            int suffixSum = 0;
            for (int num : nums) {
                suffixSum += num;
            }
            //前缀和
            int prefixSum = 0;
            for (int i = 0; i < length; i++) {
                //后缀和
                suffixSum -= nums[i];
                if (suffixSum == prefixSum) {
                    return i;
                }
                prefixSum += nums[i];
            }
            return -1;
        }
    }

    /**
     * 724. 寻找数组的中心索引
     * @param nums
     * @return
     * 前缀和
     */
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] preSumArr = new int[len];
        int[] sufSumArr = new int[len];
        for (int i = 1,j = len - 1; i < len; i++,j--) {
            preSumArr[i] = preSumArr[i-1] + nums[i-1]; //取前一个
            sufSumArr[j-1] = sufSumArr[j] + nums[j]; //存到前一个
        }
        for (int i = 0; i < len; i++) {
            if (preSumArr[i] == sufSumArr[i])return i;
        }
        return -1;
    }
}
