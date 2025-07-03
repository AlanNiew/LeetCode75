package oneQuestionPerDay;

/**
 * @author Niu
 * @date 2025-07-03
 */
public class Lt_3304 {

    public static void main(String[] args) {
        System.out.println(new Lt_3304().kthCharacter(4));
    }

    public char kthCharacter(int k) {
        StringBuilder str = new StringBuilder("a");
        while (str.length() < k){
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                tmp.append((char)(c + 1));
            }
            str.append(tmp);
        }
        return str.charAt(k-1);
    }
}
