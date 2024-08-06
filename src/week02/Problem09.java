package week02;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/6 21:21
 */
public class Problem09 {

    public static void main(String[] args) {
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(chars));
    }
    public static int compress(char[] chars) {
        StringBuilder res = new StringBuilder();
        int length = chars.length;
        int left = 0;
        int right = 0;
        int index = 0;
        while (left<length){
            res.append(chars[left]);
            while (right<length && chars[left] == chars[right]){
                right++;
            }
            int count = right - left + 1;
            if (count > 1)
                res.append(count);
            left = right;
        }
        char[] charArray = res.toString().toCharArray();
        System.arraycopy(charArray, 0, chars, 0, charArray.length);
        return charArray.length;
    }

}
