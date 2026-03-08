package oneQuestionPerDay;

/**
 * @author Niu
 * @date 2026-03-08
 */
public class Lt_1980 {

    public static void main(String[] args) {
        String[] nums = {"111","011","001"};
        System.out.println(new Lt_1980().findDifferentBinaryString(nums));
    }
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        char [] ans = new char[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i].charAt(i) == '0' ? '1' : '0';
        }
        return new String(ans);
    }
}
