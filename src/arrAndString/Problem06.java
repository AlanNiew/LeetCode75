package arrAndString;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/7/30 21:46
 */
public class Problem06 {

    public static void main(String[] args) {
//        System.out.println(reverseWords("EPY2giL"));
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("a good   example"));
    }

    static class Solution {
        public String reverseWords(String s) {
            return Arrays.stream(s.split("\\s+")).reduce( (a, b) -> b + " " + a).orElse("").trim();
        }
    }
    public static String reverseWords(String s) {
        //以空白字符串进行分割
        String[] split = s.trim().split("\\s+");
        int left = 0;
        int right = split.length - 1;
        StringBuilder starStr = new StringBuilder();
        StringBuilder endStr = new StringBuilder();
        while (left < right){
            starStr.append(split[right]).append(" ");
            String insert = split[left];
            if (left != 0) insert += " ";
            endStr.insert(0,insert);
            left++;
            right--;
        }
        if (left == right){
            if (left == 0) starStr.append(split[left]);
            else  starStr.append(split[left]).append(" ");
        }
        return starStr.append(endStr).toString();
    }
}
