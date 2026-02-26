package oneQuestionPerDay;

/**
 * @author Niu
 * @date 2026-02-03
 */
public class Lt_3637 {

    public static void main(String[] args) {

    }

    public boolean isTrionic(int[] nums) {
        int len = nums.length;
        int n = 0;
        int p, q;
        while (n < len - 1 && nums[n] < nums[n + 1]) {
            n++;
        }
        p = n;
        while (n < len - 1 && nums[n] > nums[n + 1]) {
            n++;
        }
        q = n;
        while (n < len - 1 && nums[n] < nums[n + 1]) {
            n++;
        }
        return p > 0 && p < q && q < n && n == len - 1;
    }
}
