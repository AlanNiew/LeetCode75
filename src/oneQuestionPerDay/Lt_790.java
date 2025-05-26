package oneQuestionPerDay;

/**
 * @Author: Niu
 * @Date: 2025/5/16 09:48
 * @Description: 790. 多米诺和托米诺平铺
 */
public class Lt_790 {
    public static void main(String[] args) {
        //4-11 , 5-24
        System.out.println(new Solution().numTilings(4));
    }
    static class Solution {
        public int numTilings(int n) {
            if (n <= 2){
                return n;
            }
            int total = n << 1;
            int [] dp1 = new int[n];
            dp1[0] = 1; // n = 1
            dp1[1] = 2; // n = 2
            // 多米诺，排列可能性
            for (int i = 2; i < n; i++) {
                dp1[i] = dp1[i-1] + dp1[i-2];
            }
            // 托米诺，必须成对存在 3 * 2 = 6；
            int dp2Size = total / 6;
            int [] dp2 = new int[n];
            dp2[0] = 2; // n = 6
            dp2[1] = 3; // n = 12
            for (int i = 2; i < dp2Size; i++) {
                dp2[i] = dp2[i-1] + dp2[i-2];
            }
            // 组合

            long res = dp1[n-1] + dp2[dp2Size-1];
            return (int) (res % 1000000007);
        }
    }
}
