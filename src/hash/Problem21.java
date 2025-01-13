package hash;

import java.util.*;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/21 21:39
 */
public class Problem21 {

    class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            int max = -1000;
            int min = 1000;
            for (int j : arr) {
                max = Math.max(max, j);
                min = Math.min(min, j);
            }
            int [] counts = new int[max-min+1];
            for (int i : arr) {
                counts[i-min]++;
            }
            Set<Integer> set = new HashSet<>();
            for (int count : counts) {
                if (count!=0){
                    if(set.contains(count)){
                        return false;
                    }else {
                        set.add(count);
                    }
                }
            }
            return true;
        }
    }


    /**
     * 1207. 独一无二的出现次数
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        return new HashSet<>(map.values()).size() == map.keySet().size();
    }
}
