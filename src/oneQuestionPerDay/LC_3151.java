package oneQuestionPerDay;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/13 21:07
 */
public class LC_3151 {

    public boolean isArraySpecial(int[] nums) {
        // 判断第一个元素的奇偶性
        boolean isFirstEven = nums[0] % 2 == 0;

        // 从第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            // 如果当前元素与前一个元素的奇偶性相同，则返回false
            if ((nums[i] % 2 == 0) == isFirstEven) {
                return false;
            }

            // 更新下一个元素的奇偶性的判断标准
            isFirstEven = !isFirstEven;
        }

        // 所有相邻元素的奇偶性不同，返回true
        return true;
    }
}
