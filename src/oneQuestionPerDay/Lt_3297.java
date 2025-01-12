package oneQuestionPerDay;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2025/1/9 18:53
 */
public class Lt_3297 {
    public static void main(String[] args) {
        System.out.println(new Solution().validSubstringCount("abcabc", "abc"));
    }

    static class Solution {


        /**
         * 3297. 统计重新排列后包含另一个字符串的子字符串数目 I
         * @param word1
         * @param word2
         * @return
         */
        public long validSubstringCount(String word1, String word2) {
            //word1 子串包含 word2
            int len1 = word1.length();
            int len2 = word2.length();
            if (len1 < len2) return 0;
            if (len1 == len2) return containStr(word1,word2) ? 1 : 0;
            int res = 0;
            boolean flag = false;
            int [] diff = new int[26];
            for (int i = 0; i < len1; i++) {
                if (flag){
                    diff[word1.charAt(i - 1) - 'a']--;
                    boolean f = false;
                    for (int j = i + len2; j <= len1; j++) {
                        if (f){
                            res += len1 - j + 1;
                        }else {
                            boolean t = true;
                            diff[word1.charAt(j-1)- 'a']++;
                            for (int k : diff) {
                                if (k < 0) {
                                    t = false;
                                    res++;
                                    break;
                                }
                            }
                            f = t;
                        }
                    }
                }else {
                    for (int j = i + len2; j <= len1; j++) {
                        if (flag){
                            res += len1 - j + 1;
                            break;
                        }
                        if (containStr(word1.substring(i, j),word2)){
                            flag = true;
                            res++;
                        }
                    }
                }
             }
            return res;
        }

        private boolean containStr(String word1, String word2){
            int [] arr = new int[26];
            for (int i = 0; i < word2.length(); i++) {
                arr[word2.charAt(i) - 'a']++;
            }
            for (int i = 0; i < word1.length(); i++) {
                arr[word1.charAt(i) - 'a']--;
            }
            for (int i : arr) {
                if (i > 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
