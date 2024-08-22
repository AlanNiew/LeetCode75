package week04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/21 21:06
 */
public class Problem20 {

    /**
     * 2215. 找出两数组的不同
     * @param nums1
     * @param nums2
     * @return
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> resList = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int j : nums2) {
            set2.add(j);
        }
        for (Integer integer : set1) {
            if (!set2.contains(integer)){
                list1.add(integer);
            }else {
                set2.remove(integer);
            }
        }
        resList.add(list1);
        resList.add(new ArrayList<>(set2));
        return resList;
    }

}
