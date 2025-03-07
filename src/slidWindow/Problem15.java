package slidWindow;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/11 9:03
 */
public class Problem15 {

    class Solution {
        public int maxVowels(String s, int k) {
            boolean [] letters = new boolean[26];
            letters[0] = letters['e'-'a'] = letters['i'-'a'] = letters['o'-'a'] = letters['u'-'a'] = true;
            char[] chars = s.toCharArray();
            int len = chars.length;
            int sum = 0;
            for (int i = 0; i < k; i++) {
                if (letters[(chars[i] - 'a')]) sum++;
            }
            int max = sum;
            for (int i = k; i < len; i++) {
                if(letters[chars[i] - 'a']) sum--;
                if (letters[chars[i] - 'a']) sum++;
                if (sum > max) max = sum;
                if (max == k) return k;
            }
            return max;
        }
    }

    /**
     * 1456. 定长子串中元音的最大数目
     * @param s 字符串
     * @param k 子串长度
     * @return 最大元音数
     */
    public int maxVowels(String s, int k) {
        int sum = 0;
        char[] chars = s.toCharArray();
        //先初始化窗口大小
        for (int i = 0; i < k; i++) {
            if (isVowels(chars[i]))sum++;
        }
        //窗口长度固定
        int left = 0 , right = k;
        int max = sum;
        //维护窗口大小
        while (right < chars.length){
            if (isVowels(chars[left++])) sum--;
            if (isVowels(chars[right++])) sum++;
            if (sum > max) max = sum;
        }
        return max;
    }

    private boolean isVowels(char c){
        return  c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
