package problems;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2025/1/5 15:58
 */
public class Lt_3411 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxLength(new int[]{1,2,3,1,4,5,1}));
    }

    private static class Solution{
        public int maxLength(int[] nums) {
            int res = 1,len = nums.length;
            int left = 0,right = 1;
            while (left < right && right < len){
                while (right < len && verify(nums,left,right)) {
                    res = Math.max(res,right - left + 1);
                    right++;
                }
                left++;
            }
            return res;
        }

        private boolean verify(int []arr,int start,int end){
            int multi = 1;
            for (int i = start; i <= end; i++) {
                multi *= arr[i];
            }
            int gcd = gcd(arr[start], arr[start + 1]);
            for (int i = start + 2; i <= end; i++){
                gcd = gcd(gcd, arr[i]);
            }
            int lcm = lcm(arr[start], arr[start + 1]);
            for (int i = start + 2; i <= end; i++){
                lcm = lcm(lcm, arr[i]);
            }
            return multi == lcm * gcd;
        }

        /**
         * 求最大公约数
         */
        public int gcd(int a,int b){
            if (b == 0) return a;
            return gcd(b, a % b);
        }

        /**
         * 求最小公倍数
         */
        public int lcm(int a,int b){
            return (a * b) / gcd(a,b);
        }

    }


}
