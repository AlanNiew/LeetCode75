package oneQuestionPerDay;

import java.util.Arrays;

/**
 * @author Niu
 * @date 2025-12-25
 */
public class Lt_3075 {

    public long maximumHappinessSum(int[] happiness, int k) {
        int length = happiness.length;
        long max = 0;

        // 对幸福感数组进行升序排序
        Arrays.sort(happiness);
        
        int n = 0;
        int index = length - 1;
        while (index >= 0 && n < k) {
            int happyValue = happiness[index] - n;
            if (happyValue <= 0){
                break;
            }
            max+=happyValue;
            n++;
            index--;
        }
        return max;
    }

}