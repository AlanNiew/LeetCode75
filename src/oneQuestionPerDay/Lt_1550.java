package oneQuestionPerDay;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2025/5/11 8:56
 */
public class Lt_1550 {

    class Solution {
        public boolean threeConsecutiveOdds(int[] arr) {
            int len = arr.length;
            for (int i = 2; i < len; i++) {
                if (isOdd(arr[i]) && isOdd(arr[i - 1]) && isOdd(arr[i - 2])){
                    return true;
                }
            }
            return false;
        }

    }
    private boolean isOdd(int num){

        return (num & 1) == 1;
    }

    private void swap(int [] arr,int i,int j){
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }

    public static void main(String[] args) {
        int a = 10;
    }
}
