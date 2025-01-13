package hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/23 21:40
 */
public class Problem23 {
    public static void main(String[] args) {
        System.out.println(new Solution().equalPairs(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}));
    }
    static class Solution {
        public int equalPairs(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int res = 0;
            //存储行
            Set<int[]> rowSet = new HashSet<>(Arrays.asList(grid));
            for (int i = 0; i < m; i++) {
                //遍历列
                int[] col = new int[m];
                for (int j = 0; j < n; j++) {
                    col[j] = grid[j][i];
                }
                for (int[] ints : rowSet) {
                    if (Arrays.equals(ints,col)){
                        res++;
                    }
                }
            }
            return res;
        }
    }

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
