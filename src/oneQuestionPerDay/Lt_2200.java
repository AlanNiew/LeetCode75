package oneQuestionPerDay;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Niu
 * @date 2025-06-24
 */

public class Lt_2200{

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int len = nums.length;
        List<Integer> indexList = new ArrayList<>();
        // k近邻的所有下标
        List<Integer> res = new ArrayList<>();
        // 先找到符合key的元素下标
        for (int i = 0; i < len; i++) {
            if (nums[i] == key) {
                indexList.add(i);
            }
        }

        for (int i = 0; i < len; i++) {
            for (Integer index : indexList) {
                if (Math.abs(i - index) <= k){
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}
