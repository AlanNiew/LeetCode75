package oneQuestionPerDay;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Niu
 * @date 2025-07-15
 */
public class Lt_3136 {


    /**
     * 至少 包含 3 个字符。
     * 由数字 0-9 和英文大小写字母组成。（不必包含所有这类字符。）
     * 至少 包含一个 元音字母 。
     * 至少 包含一个 辅音字母
     */
    public boolean isValid(String word) {
        // aeiou
        Set<Character> set = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        char[] charArray = word.toCharArray();

        return true;
    }

    public static void main(String[] args) {

    }
}
