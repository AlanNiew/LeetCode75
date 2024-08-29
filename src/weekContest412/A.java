package weekContest412;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/25 10:32
 */
public class A {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int min = findMin(nums);
            nums[min] = nums[min]*multiplier;
        }
        return nums;
    }

    //寻找数组最小元素下标
    public int findMin(int[] nums){
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < min){
                min = nums[i];
                index = i;
            }
        }
        return index;
    }
}
