package arrAndString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/1 19:09
 */
public class Problem03 {

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
