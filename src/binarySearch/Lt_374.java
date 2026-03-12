package binarySearch;

/**
 * Author:Niu
 * Data:2024/10/3 10:47
 */
public class Lt_374 {
    public static void main(String[] args) {
        System.out.println(new Lt_374().guessNumber(10));
    }

    private final int pick = 6;
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            int res = guess(mid);
            if (res == 0){
                return mid;
            }else if (res == -1){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return n;
    }

    int guess(int num) {
        return Integer.compare(pick, num);
    }
}
