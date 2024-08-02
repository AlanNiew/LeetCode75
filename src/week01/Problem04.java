package week01;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/2 18:33
 */
public class Problem04 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] a = new int[flowerbed.length + 2];
        System.arraycopy(flowerbed, 0, a, 1, flowerbed.length);
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i - 1] == 0 && a[i] == 0 && a[i + 1] == 0) {
                a[i] = 1; // 种花！
                n--;
            }
        }
        return n <= 0;
    }

}
