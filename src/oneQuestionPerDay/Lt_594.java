package oneQuestionPerDay;

/**
 * @author Niu
 * @date 2025-06-30
 */

public class Lt_594 {

    public static void main(String[] args) {
        int[] nums = {1,3,2,2,5,2,3,7};
        System.out.println(new Lt_594().findLHS(nums));
    }

    public int findLHS(int[] nums) {
        int len = nums.length;
        int max = 0;
        int left = 0,right = 1;
        while (right < len){
            while (right < len && Math.abs(nums[right] - nums[left]) == 1){
                right++;
            }
            max = Math.max(right - left,max);
            left = right;
            right++;
        }
        return max;
    }
}
