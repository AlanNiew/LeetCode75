package arrAndString;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/7/30 21:05
 * 
 * LeetCode 1768. 交替合并字符串
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。
 * 如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 */
public class Problem01 {
    public static void main(String[] args) {
        // 测试用例
        System.out.println("测试1: " + mergeAlternately("abc", "pqr")); // 期望: "apbqcr"
        System.out.println("测试2: " + mergeAlternately("ab", "pqrs")); // 期望: "apbqrs"
        System.out.println("测试3: " + mergeAlternately("abcd", "pq")); // 期望: "apbqcd"
        System.out.println("测试4: " + mergeAlternately("abc", "pqr112")); // 期望: "apbqcr112"
    }

    /**
     * 交替合并两个字符串
     * 时间复杂度: O(m + n)，其中 m 和 n 分别是两个字符串的长度
     * 空间复杂度: O(m + n)，用于存储结果字符串
     * 
     * @param word1 第一个字符串
     * @param word2 第二个字符串
     * @return 交替合并后的字符串
     */
    public static String mergeAlternately(String word1, String word2) {
        // 输入校验
        if (word1 == null) return word2 == null ? "" : word2;
        if (word2 == null) return word1;
        
        StringBuilder result = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int maxLen = Math.max(len1, len2);
        
        // 交替添加字符
        for (int i = 0; i < maxLen; i++) {
            if (i < len1) {
                result.append(word1.charAt(i));
            }
            if (i < len2) {
                result.append(word2.charAt(i));
            }
        }
        
        return result.toString();
    }
    
    /**
     * 解决方案类（LeetCode 标准格式）
     */
    static class Solution {
        public String mergeAlternately(String word1, String word2) {
            return Problem01.mergeAlternately(word1, word2);
        }
    }
}
