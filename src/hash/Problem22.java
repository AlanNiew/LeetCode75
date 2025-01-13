package hash;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/21 21:47
 */
public class Problem22 {

    public static void main(String[] args) {
        System.out.println(new Solution().closeStrings("aaabbbbccddeeeeefffff",
                "aaaaabbcccdddeeeeffff"));
    }

    static class Solution {
        public boolean closeStrings(String word1, String word2) {
            int len1 = word1.length();
            int len2 = word2.length();
            if (len1 != len2) return false;
            char[] chars1 = word1.toCharArray();
            char[] chars2 = word2.toCharArray();
            int [] arr1 = new int[26];
            int [] arr2 = new int[26];
            for (int i = 0; i < len1; i++) {
                arr1[chars1[i] - 'a']++;
                arr2[chars2[i] - 'a']++;
            }
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                if (arr1[i] == 0 && arr2[i] == 0)continue;
                if (arr1[i] == 0 && arr2[i] != 0) return false;
                if (arr1[i] != 0 && arr2[i] == 0) return false;
                if (arr1[i] != arr2[i]){
                    list1.add(arr1[i]);
                    list2.add(arr2[i]);
                }
            }
            for (Integer integer : list1) {
                int indexOf = list2.indexOf(integer);
                if (indexOf == -1){
                    return false;
                }else {
                    list2.remove(indexOf);
                }
            }
            return true;
        }
    }

    /**
     * 思路：1.判断长度是否相等，不相等直接返回false
     * 2.判断两个map的key是否相等，如果相等，判断value是否相等
     * 不同的字母数量要一致，否则返回false
     * @param word1
     * @param word2
     * @return
     */
    public boolean closeStrings(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        if (length1 != length2)return false;
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int [] cIndex1 = new int[26];
        int [] cIndex2 = new int[26];
        int a = 'a';
        for (int i = 0; i < length1; i++) {
            cIndex1[chars1[i] - 'a']++;
            cIndex2[chars2[i] - 'a']++;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int i = 0; i < 26; i++) {
            int k1 = cIndex1[i];
            int k2 = cIndex2[i];
            if (k1 == 0 && k2 == 0) continue;
            if (k1 == 0 || k2 == 0) return false;
            if (k1 != k2){
                priorityQueue.offer(k1);
                priorityQueue1.offer(k2);
            }
        }
        while (!priorityQueue.isEmpty()){
            if (!Objects.equals(priorityQueue.poll(), priorityQueue1.poll()))return false;
        }
        return true;
    }

}
