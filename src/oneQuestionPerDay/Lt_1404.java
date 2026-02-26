package oneQuestionPerDay;

/**
 * @author Niu
 * @date 2026-02-26
 */
public class Lt_1404 {
    public static void main(String[] args) {
        System.out.println("answer:"+ new Lt_1404().numSteps("1111110011101010110011100100101110010100101110111010111110110010"));
    }
    
    public int numSteps(String s) {
        // 直接在二进制字符串上操作，避免大数转换
        int steps = 0;
        int carry = 0;  // 进位
        
        // 从右到左处理每一位（除了最高位的1）
        for (int i = s.length() - 1; i > 0; i--) {
            int bit = s.charAt(i) - '0';
            // 当前位的值（考虑进位）
            int current = bit + carry;
            
            if (current % 2 == 0) {
                // 偶数：除以2，只需要1步
                steps += 1;
                carry = current / 2;
            } else {
                // 奇数：加1变成偶数，再除以2，需要2步
                steps += 2;
                carry = (current + 1) / 2;
            }
        }
        
        // 处理最高位
        if (carry == 1) {
            steps += 1;
        }
        
        return steps;
    }
}