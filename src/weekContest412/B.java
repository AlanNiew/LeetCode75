package weekContest412;

import java.util.*;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/25 10:35
 */
public class B {

    public int countPairs(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                //验证交换两个数位是否相等
                if (Objects.equals(nums[i], nums[j]) || checkEqual(nums[i], nums[j]))ans++;
            }
        }
        return ans;
    }

    public boolean checkEqual(int num1, int num2) {
        return swapNum2IsEqualNum1(num1,num2) || swapNum2IsEqualNum1(num2,num1);
    }

    public boolean swapNum2IsEqualNum1(int num1, int num2){
        String str2 = Integer.toString(num2);
        char[] chars2 = str2.toCharArray();
        for (int i = 0; i < chars2.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                if (i == j)continue;
                char temp = chars2[i];
                chars2[i] = chars2[j];
                chars2[j] = temp;
                int k = Integer.parseInt(new String(chars2));
                if (k == num1)return true;
                //交换回来
                temp = chars2[i];
                chars2[i] = chars2[j];
                chars2[j] = temp;
            }
        }
        return false;
    }


}
