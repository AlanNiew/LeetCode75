package oneQuestionPerDay;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2025/1/8 18:18
 */
public class Lt_2264 {

    public static void main(String[] args) {
        System.out.println(new Solution().largestGoodInteger("42352338"));
    }
    static class Solution {
        public String largestGoodInteger(String num) {
            int len = num.length();
            int [] arr = new int[10];
            char[] chars = num.toCharArray();
            for (int i = 0; i < len - 2; i++) {
                if(chars[i] == chars[i+1] && chars[i] == chars[i+2]){
                    arr[chars[i]-'0']++;
                }
            }
            for (int i = 9; i >= 0 ; i--) {
                if (arr[i]!=0){
                    return String.valueOf(i).repeat(3);
                }
            }
            return "";
        }

        private int strAllEqualToNum(String str){
            char c = str.charAt(0);
            for (int i = 1; i < str.length(); i++) {
                if (c != str.charAt(i)){
                    return -1;
                }
            }
            return c-'0';
        }
    }
}
