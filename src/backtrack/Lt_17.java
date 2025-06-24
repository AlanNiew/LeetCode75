package backtrack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2025/5/16 21:48
 */
public class Lt_17 {
    private static final Map<Integer,char[]> map = new HashMap<>();
    static {
        map.put(2,new char[]{'a','b','c'});
        map.put(3,new char[]{'d','e','f'});
        map.put(4,new char[]{'g','h','i'});
        map.put(5,new char[]{'j','k','l'});
        map.put(6,new char[]{'m','n','o'});
        map.put(7,new char[]{'p','q','r','s'});
        map.put(8,new char[]{'t','u','v'});
        map.put(9,new char[]{'w','x','y','z'});
    }

    public static void main(String[] args) {
        System.out.println(Character.getNumericValue('c'));
//        System.out.println(letterCombinations("3452"));
    }
    public static List<String> letterCombinations(String digits) {
        if ("".equals(digits)) return new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("");
        for (char c : digits.toCharArray()) {
            int key = c - '0';
            char[] chars = map.get(key);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String base = queue.poll();
                for (char aChar : chars) {
                    queue.offer(base + aChar);
                }
            }
        }
        return new ArrayList<>(queue);
    }
}
