package oneQuestionPerDay;

/**
 * @author Niu
 * @date 2025-12-26
 */
public class Lt_2483 {


    public static void main(String[] args) {
        Lt_2483 lt_2483 = new Lt_2483();
        System.out.println(lt_2483.bestClosingTime("YYNY"));
    }
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] prices = new int[n + 1];
        prices[n] = customers.replace("Y", "").length();
        int min = prices[n];
        int ans = n;
        for (int i = n - 1; i >= 0; i--) {
            if (customers.charAt(i) == 'Y') {
                prices[i] = prices[i + 1] + 1;
            } else {
                prices[i] = prices[i + 1] - 1;
            }
            if (prices[i] <= min) {
                min = prices[i];
                ans = i;
            }
        }
        return ans;
    }
}
