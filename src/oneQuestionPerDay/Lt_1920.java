package oneQuestionPerDay;

/**
 * @author Niu
 * @date 2025-06-27
 */

public class Lt_1920 {

    public static void main(String[] args) {
        int[] nums = {0,2,1,5,3,4};
    }

    public int[] buildArray(int[] nums) {
        int len = nums.length;
        int [] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }
}
