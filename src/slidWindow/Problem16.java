package slidWindow;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/11 9:16
 */
public class Problem16 {

    public static void main(String[] args) {
        System.out.println(new Solution().longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }

    /**
     * 1004. 最大连续1的个数 III
     *
     * @param nums
     * @param k
     * @return 《挑战程序设计竞赛》这本书中把滑动窗口叫做「虫取法」，我觉得非常生动形象。因为滑动窗口的两个指针移动的过程和虫子爬动的过程非常像：前脚不动，把后脚移动过来；后脚不动，把前脚向前移动。
     * <p>
     * 以右指针作为驱动，拖着左指针向前走。右指针每次只移动一步，而左指针在内部 while 循环中每次可能移动多步。右指针是主动前移，探索未知的新区域；左指针是被迫移动，负责寻找满足题意的区间。
     * <p>
     * 作者：负雪明烛
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int longestOnes(int[] nums, int k) {
        int res = -1;
        int n = k; //窗口大小
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                n--; //窗口大小-1
            }
            while (n < 0) {
                //窗口大小小于0，窗口左边界向右移动,保证窗口大小>=0
                if (nums[left] == 0) n++;
                left++;
            }
            int s = right - left + 1;
            res = Math.max(res, s);
            right++;
        }
        return res;
    }

    static class Solution {
        public int longestOnes(int[] nums, int k) {
            int len = nums.length;
            int left = 0, right = 0;
            while (right < len) {
                if (nums[right] == 0) {
                    k--;
                }
                //窗口小于0，不断移动left
                if (k < 0 && nums[left++] == 0) {
                    k ++;
                }
                right++;
            }
            return right - left;
        }
    }
}
