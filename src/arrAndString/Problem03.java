package arrAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/1 19:09
 */
public class Problem03 {

    class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            //先获取最大值
            int max = Arrays.stream(candies).max().orElse(0);
            //一一比较给谁是否大于max
            List<Boolean> res = new ArrayList<>();
            for (int candy : candies) {
                res.add(candy + extraCandies >= max);
            }
            return res;
        }
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        List<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            if (candy + extraCandies >= max) res.add(true);
            else res.add(false);
        }
        return res;
    }
}
