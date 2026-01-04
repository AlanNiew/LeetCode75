package oneQuestionPerDay;

import java.util.Arrays;

/**
 * @author Niu
 * @date 2026-01-03
 */
public class Lt_3791 {

    public static void main(String[] args) {
        Lt_3791 lt_3791 = new Lt_3791();
        System.out.println(lt_3791.countBalanced(11144, 977905));
    }

    public long countBalanced(long low, long high) {
        // 使用前缀和的思想：countBalanced(high) - countBalanced(low-1)
        return countBalanced(high) - countBalanced(low - 1);
    }
    
    // 计算 [0, n] 范围内平衡数的个数
    private long countBalanced(long n) {
        if (n < 0) return 0;
        String numStr = String.valueOf(n);
        int len = numStr.length();
        // 初始化记忆化数组，使用-1表示未计算过
        long[][][][] memo = new long[len][100][100][2];
        for (long[][][] a : memo) {
            for (long[][] b : a) {
                for (long[] c : b) {
                    Arrays.fill(c, -1);
                }
            }
        }
        return dp(numStr, 0, 0, 0, true, false, memo);
    }
    
    /**
     * 数位DP函数
     * @param numStr 目标数字的字符串表示
     * @param pos 当前处理的位置
     * @param oddSum 奇数位的和
     * @param evenSum 偶数位的和
     * @param isLimit 是否受到上界限制
     * @param isNum 当前是否已开始填数字
     * @param memo 记忆化数组
     * @return 满足条件的数字个数
     */
    private long dp(String numStr, int pos, int oddSum, int evenSum, boolean isLimit, boolean isNum, long[][][][] memo) {
        if (pos == numStr.length()) {
            // 如果已经形成了一个数字，且奇数位和等于偶数位和
            return isNum && oddSum == evenSum ? 1 : 0;
        }
        
        if (!isLimit && isNum && memo[pos][oddSum][evenSum][0] != -1) {
            return memo[pos][oddSum][evenSum][0];
        }
        
        long res = 0;
        
        // 如果还没有开始填数字，可以选择跳过当前位置（前导0）
        if (!isNum) {
            res += dp(numStr, pos + 1, oddSum, evenSum, false, false, memo);
        }
        
        // 确定当前位可以填的数字范围
        int start = isNum ? 0 : 1; // 如果还没开始填数字，从1开始（避免前导0）
        int end = isLimit ? numStr.charAt(pos) - '0' : 9; // 如果受限制，不能超过对应位的数字
        
        for (int digit = start; digit <= end; digit++) {
            // 计算新的奇偶位和
            int newOddSum = oddSum;
            int newEvenSum = evenSum;
            
            // pos从0开始，偶数索引（0,2,4...）是奇数位（从左往右数第1,3,5...位）
            if (pos % 2 == 0) {
                newOddSum += digit;
            } else {
                newEvenSum += digit;
            }
            
            // 如果奇数位和或偶数位和超过限制（数字最大9位，每位最大9，所以和最大81），直接跳过
            if (newOddSum > 81 || newEvenSum > 81) {
                continue;
            }
            
            res += dp(numStr, pos + 1, newOddSum, newEvenSum, 
                     isLimit && digit == end, true, memo);
        }
        
        if (!isLimit && isNum) {
            memo[pos][oddSum][evenSum][0] = res;
        }
        
        return res;
    }
    
    // 原来的辅助方法保留，但不会在优化后的算法中使用
    private int[] numToArray(long num) {
        String numStr = String.valueOf(num);
        int[] res = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            res[i] = numStr.charAt(i) - '0';
        }
        return res;
    }
    
    private boolean odd_even_sum_equal(int[] numArray) {
        int odd_sum = 0;
        int even_sum = 0;
        for (int i = 0; i < numArray.length; i++) {
            if (i % 2 == 0) {
                odd_sum += numArray[i];
            } else {
                even_sum += numArray[i];
            }
        }
        return odd_sum == even_sum;
    }
}
