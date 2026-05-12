package bit;

/**
 * @author Niu
 * @date 2026-05-09
 */
public class Problem67_Lt338 {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i = 1; i <= n; i++){
            ans[i] = ans[i>>1]+(i&1);
        }
        return ans;
    }
}
