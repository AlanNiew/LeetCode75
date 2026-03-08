package oneQuestionPerDay;

/**
 * @author Niu
 * @date 2025-07-02
 */

public class Lt_3333 {

    public static void main(String[] args) {


    }

    public int possibleStringCount(String word, int k) {
        char[] chars = word.toCharArray();
        int left = 0,right = 1,len = chars.length;
        int ans = 1;
        while (right < len){
            while (right < len && chars[right] == chars[left]){
                right ++;
                ans++;
            }
        }
        return ans;
    }
}
