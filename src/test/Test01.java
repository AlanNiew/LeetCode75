package test;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/4 17:41
 */
public class Test01 {

    public static void main(String[] args) {
        int[] arr = {3,3,4,4,1,2};
        int n = 0;
        for (int j : arr) {
            n ^= j;
        }
        int rightOne = n & (~n + 1); //取反后获取最右侧的一位1
        int m = n;
        for (int i : arr) {
            if ((i & rightOne) == 1){
                m^=i;
            }
        }
        System.out.println(m+" , "+(m^n));
    }
}
