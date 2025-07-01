package oneQuestionPerDay;

/**
 * @author Niu
 * @date 2025-07-01
 */

public class Lt_3330 {

    public static void main(String[] args) {
        System.out.println(new Lt_3330().possibleStringCount("aaaa"));
    }

    public int possibleStringCount(String word) {
        // 寻找连续相同的字符
        char[] chars = word.toCharArray();
        int left = 0,right = 1,len = chars.length;
        int ans = 1;
        while (right < len){
            while (right < len && chars[right] == chars[left]){
                right ++;
                ans++;
            }
            left = right;
            right++;
        }
        return ans;
    }
}
