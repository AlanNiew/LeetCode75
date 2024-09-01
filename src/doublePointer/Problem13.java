package doublePointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/9 20:19
 */
public class Problem13 {

    /**
     * 1679. K 和数对的最大数目
     * 哈希
     */
    public int maxOperations(int[] nums, int k) {
        int operation = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int key = k - num;
            Integer v = map.getOrDefault(key, 0);
            //存在，直接计算
            if (v>0){
                operation++;
                map.put(key,v-1);
            }else {
                //不存在，存入
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }
        return operation;
    }

    //双指针
    public int maxOperations1(int[] nums, int k) {
        int operation = 0;
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);
        while (left<right){
            int n = nums[left] + nums[right];
            if (n<k){
                left++;
            }else if (n>k){
                right--;
            }else {
                operation++;
                right--;
                left++;
            }
        }
        return operation;
    }

}
