package oneQuestionPerDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Niu
 * @date 2026-04-10
 */
public class Lt_3740 {

    static class Solution {

        public static void main(String[] args) {
            System.out.println(new Solution().minimumDistance(new int[]{1, 2, 1, 1, 3}));
        }
        public int minimumDistance(int[] nums) {
            // 相同元素下标位置，最近的三个
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
                list.add(i);
                map.put(nums[i], list);
            }
            int min = Integer.MAX_VALUE;
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                List<Integer> list = entry.getValue();
                if (list.size()<3){
                    continue;
                }
                int distance = distance(list);
                min = Math.min(min, distance);
            }
            if (min == Integer.MAX_VALUE){
                return -1;
            }else return min;
        }
        private static int distance(List<Integer> indexList) {
            //计算三个的距离
            int size = indexList.size();
            int i=0,j=1,k=2;
            int min = Integer.MAX_VALUE;
            do{
                Integer i1 = indexList.get(i++);
                Integer j1 = indexList.get(j++);
                Integer k1 = indexList.get(k++);
                int dis = Math.abs(i1-j1)+Math.abs(j1-k1)+Math.abs(i1-k1);
                min = Math.min(min,dis);
            }while (k<size);
            return min;
        }
    }



}
