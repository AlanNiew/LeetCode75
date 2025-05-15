package dp;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2025/5/15 21:43
 */
public class Lt_1137 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.tribonacci(2));
    }

    static class Solution {

        public int tribonacci(int n) {
            if (n==0) return 0;
            if (n<=2) return 1;
            int[] arr= new int[n+1];
            arr[1] = 1;arr[2] = 1;
            for (int i = 3; i <= n; i++) {
                arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
            }
            return arr[n];
        }
    }
}
