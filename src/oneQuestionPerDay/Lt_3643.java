package oneQuestionPerDay;

/**
 * @author Niu
 * @date 2026-03-21
 */
public class Lt_3643 {
        public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
            // x，y,行数
            int m = grid.length;
            int n = grid[0].length;
//            int [][] tmp = new int[m][n];
            // k = 3, 1-3， 1+3 = 4 / 2 = 2
            // k = 4, 1-4,2-3 
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i >= x && i < x + k / 2 && j >= y && j < y + k ) {
                        // 交换
                        int tmp = grid[i + k][j];
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            return grid;
        }
}
