package prefix.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Niu
 * @date 2026-05-09
 */
public class Problem71_Lt1268 {
    public static void main(String[] args) {
        String [] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        System.out.println(new Problem71_Lt1268().suggestedProducts(products, "mouse"));
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        List<String> source = List.of(products);
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> temp = new ArrayList<>();
            String prefix = searchWord.substring(0, i);
            for (String s : source) {
                if (s.startsWith(prefix)) {
                    temp.add(s);
                }
                if (temp.size() >= 3) break;
            }
            res.add(temp);
        }
        return res;
    }
}
