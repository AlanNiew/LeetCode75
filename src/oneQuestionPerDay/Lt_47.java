package oneQuestionPerDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2025/2/6 20:37
 */
public class Lt_47 {



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = solution.permuteUnique(nums);
        System.out.println(lists);
    }

    static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums); // 先排序
            boolean[] used = new boolean[nums.length];
            backtrack(ans, new ArrayList<>(), nums, used);
            return ans;
        }

        private void backtrack(List<List<Integer>> ans, List<Integer> tempList, int[] nums, boolean[] used) {
            if (tempList.size() == nums.length) {
                ans.add(new ArrayList<>(tempList));
            } else {
                for (int i = 0; i < nums.length; i++) {
                    if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue; // 跳过重复元素
                    used[i] = true;
                    tempList.add(nums[i]);
                    backtrack(ans, tempList, nums, used);
                    used[i] = false;
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}
