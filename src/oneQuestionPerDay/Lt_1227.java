package oneQuestionPerDay;

/**
 * Author:Niu
 * Data:2024/10/4 10:50
 */
public class Lt_1227 {
    public static void main(String[] args) {

    }
    public double nthPersonGetsNthSeat(int n) {
        if (n == 1)return 1;
        double res = 1;
        for (int i = 0; i < n - 1; i++) {
            res = res*0.5;
        }
        return res;
    }
}
