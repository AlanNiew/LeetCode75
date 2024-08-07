package week02;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/5 18:54
 */
public class Problem08 {

    public static void main(String[] args) {
        Problem08 problem08 = new Problem08();
        int[] ints = {1,5,0,4,1,3};
        boolean b = problem08.increasingTriplet(ints);
        System.out.println(b);
    }

    /**
     * 给你一个整数数组nums ，判断这个数组中是否存在长度为 3 的递增子序列。
     * 只关注存在即可
     * @param nums 整数数组
     * @return 是否存在长度为 3 的递增子序列
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num; // 更新第一个最小值
            } else if (num <= second) {
                second = num; // 更新第二个最小值
            } else {
                return true; // 找到了比second大的数，构成递增子序列
            }
        }
        return false;
    }
}
