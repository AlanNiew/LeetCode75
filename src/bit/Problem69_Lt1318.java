package bit;

/**
 * @author Niu
 * @date 2026-05-09
 */
public class Problem69_Lt1318 {
    public static void main(String[] args) {
        System.out.println(new Problem69_Lt1318().minFlips(7, 7, 7));
    }
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < 30; i++) {
            // 从右向左依次看0/1
            int x = a >> i & 1, y = b >> i & 1, z = c >> i & 1;
            if (z == 0) ans += x + y;
            else if (x == 0 && y == 0) ans++;
        }
        return ans;
    }
}
