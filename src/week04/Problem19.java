package week04;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/20 20:30
 */
public class Problem19 {

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
