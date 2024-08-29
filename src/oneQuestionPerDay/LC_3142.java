package oneQuestionPerDay;

import java.util.Arrays;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/29 20:18
 */
public class LC_3142 {

    public boolean satisfiesConditions(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //遍历每一行,是否相等
        for (int i = 0; i < m - 1; i++) {
            int [] cur = grid[i];
            int [] down = grid[i + 1];
            if (!Arrays.equals(cur,down))return false;
        }
        //遍历每一列
        for (int j = 0; j < n - 1; j++) {
            int cur = grid[0][j];
            int right = grid[0][j + 1];
            if (cur==right)return false;
        }
        return true;
    }
}
