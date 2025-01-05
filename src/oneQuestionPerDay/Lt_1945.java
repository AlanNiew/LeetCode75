package oneQuestionPerDay;

/**
 * Author:Niu
 * Data:2024/10/13 9:19
 */
public class Lt_1945 {

    public static void main(String[] args)
    {
        String s = "iiii";
        int k = 2;
        System.out.println(new Lt_1945().getLucky(s, k));
    }
    public int getLucky(String s, int k){
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append((c - 'a') + 1);
        }
        for (int i = 0; i < k; i++) {
            int n = strAllSum(sb.toString());
            sb = new StringBuilder(String.valueOf(n));
        }
        return Integer.parseInt(sb.toString());
    }

    public int strAllSum(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }
        return sum;
    }
}
