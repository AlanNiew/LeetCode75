package oneQuestionPerDay;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2025/1/16 18:22
 */
public class Lt_3095 {
    public static void main(String[] args) {
        System.err.println(new Solution().minimumSubarrayLength(new int[]{32,1,25,11,2}, 59));
    }
    static class Solution {
        public int minimumSubarrayLength(int[] nums, int k) {
            int res = 51;
            int len = nums.length;
            //分割连续子数组
            for (int i = 0; i < len; i++) {
                for (int j = i+1; j <= len; j++) {
                    int bitwiseOr = bitwiseOr(nums, i, j);
                    System.out.print("\t"+bitwiseOr+"\n");
                    if (bitwiseOr>k){
                        res = Math.min(res,j-i);
                        if (res == 1)return 1;
                    }
                }
            }
            return res==51?-1:res;
        }

        private int bitwiseOr(int[] nums,int start,int end) {
            int result = 0;
            for (int i = start; i < end; i++) {
                System.out.print(nums[i]+",");
                result |= nums[i];  // 按位或运算
            }
            return result;
        }
    }
}
