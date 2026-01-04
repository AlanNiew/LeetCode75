package oneQuestionPerDay;

/**
 * @author Niu
 * @date 2026-01-03
 */
public class Lt_3790 {

    public static void main(String[] args) {
        Lt_3790 lt_3790 = new Lt_3790();
        System.out.println(lt_3790.minAllOneMultiple(23));
    }
    /**
     * 找出满足以下条件的 最小 整数 n：n 能被 k 整除，且其十进制表示中 只包含数字 1（例如：1、11、111、……）。
     *
     * @param k 一个正整数。
     * @return 满足条件的最小整数 n 的十进制表示的位数。如果不存在这样的 n，则返回 -1。
     */
    public int minAllOneMultiple(int k) {
        if (k == 1) {
            return 1;
        }
        //如果被2或5整除，则返回-1
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int res = 1;
        int remainder = 1 % k;  // 使用取模运算避免溢出
        while (remainder != 0){
            remainder = (remainder * 10 + 1) % k;  // 每次都取模
            System.out.println(remainder);
            res++;
            if (res > k) {  // 如果位数超过k，说明进入循环，不存在解
                return -1;
            }
        }
        return res;
    }

}
