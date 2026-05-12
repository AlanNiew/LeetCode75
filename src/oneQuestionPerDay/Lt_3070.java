package oneQuestionPerDay;

/**
 * @author Niu
 * @date 2026-03-18
 */
public class Lt_3070 {
    public int countSubmatrices(int[][] grid, int k) {
        // 层次遍历
        int m = grid.length, n = grid[0].length;
        int[][] preSum = new int[m+1][n+1];
        int[][] colSum = new int[m+1][n+1];
        int[][] rowSum = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                colSum[i][j] = 0;
            }
        }

        return k;
    }
}
