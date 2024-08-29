package week04;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/23 21:40
 */
public class Problem23 {

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        int[][] colGrid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                colGrid[i][j] = grid[j][i];
            }
            for (int j = 0; j < n; j++) {
                if (Arrays.equals(colGrid[j],grid[j]))ans++;
            }
        }
        return ans;
    }
}
