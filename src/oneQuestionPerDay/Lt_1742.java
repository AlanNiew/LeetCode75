package oneQuestionPerDay;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Niu
 * @date 2025-07-12
 */
public class Lt_1742 {


    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        // 每位数字和
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = getSum(i);
            Integer value = map.getOrDefault(sum, 0);
            value++;
            map.put(sum, value );
            if (value > max){
                max = value;
            }
        }
        return max;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
