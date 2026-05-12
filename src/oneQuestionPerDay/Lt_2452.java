package oneQuestionPerDay;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Niu
 * @date 2026-04-22
 */
public class Lt_2452 {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List <String> res = new ArrayList<>();
        //差异在两个字母以内的单词
        //前缀匹配，字典序
        for (String query : queries) {
            for (String s : dictionary) {
                int count = 0;
                for (int i = 0; i < query.length(); i++) {
                    if (query.charAt(i) != s.charAt(i)) {
                        count++;
                    }
                    if (count>2)break;
                }
                if (count<=2){
                    res.add(query);
                }
            }
        }
        return res;
    }
}
