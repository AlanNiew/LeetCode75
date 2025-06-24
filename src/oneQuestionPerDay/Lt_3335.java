package oneQuestionPerDay;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2025/5/13 22:32
 */
public class Lt_3335 {

    class Solution {
        public int lengthAfterTransformations(String s, int t) {
            int mod = 1000000007;
            char[] chars = s.toCharArray();
            long res = s.length();
            for (char aChar : chars) {
                int dis = aChar - 'z';
                int n = dis / t;
            }
            return s.length() % mod;
        }

        private String transformation(String s){
            StringBuilder res = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == 'z'){
                    res.append("ab");
                }else{
                    res.append((char)('c'+1));
                }
            }
            System.out.println(res);
            return res.toString();
        }
    }
}
