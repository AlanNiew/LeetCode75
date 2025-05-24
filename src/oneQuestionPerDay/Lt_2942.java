package oneQuestionPerDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2025/5/24 22:34
 */
public class Lt_2942 {

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.indexOf(x) != -1) {
                res.add(i);
            }
        }
        return res;
    }
}
