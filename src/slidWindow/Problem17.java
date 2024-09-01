package slidWindow;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/13 21:18
 */
public class Problem17 {

    public static void main(String[] args) {

    }

    /**
     * 1493. 删掉一个元素后全为 1 的最长子数组
     * @param nums
     * @return
     * @author SouthWind
     * 滑动窗口核心；两个指针一前一后移动，并且同时只能有一个移动
     */
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int n = 1; //窗口中只能出现一个0
        int res = 0;
        while (right<len){
            if (nums[right]==0){
                n--;
            }
            while (n<0){
                if (nums[left]==0) n++;
                left++;
            }
            int s = right - left;
            res = Math.max(res,s);
            right++;
        }
        return res;
    }
}
