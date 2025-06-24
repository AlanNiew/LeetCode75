package week157;

import java.util.*;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2025/5/24 22:44
 */
public class A {
    public static void main(String[] args) {

    }

    public long sumOfLargestPrimes(String s) {
        Set<Long> set = new TreeSet<>(Comparator.reverseOrder());
        // 子串
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
                long num = Long.parseLong(sb.toString());
                if (isPrime(num)) {
                    set.add(num);
                }
            }
        }
        long res = 0;
        int i = 0;
        for (long integer : set) {
            res += integer;
            i++;
            if (i == 3)break;
        }
        return res;
    }

    // 质数
    public boolean isPrime(long n) {
        if (n < 2) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
