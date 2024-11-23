package oneQuestionPerDay;

import java.util.Arrays;

/**
 * Author:Niu
 * Data:2024/10/13 9:27
 */
public class Lt_1878 {
    public static void main(String[] args) {
        new Lt_1878().getBiggestThree(new int[][]{
                {3,4,5,1,3},{3,3,4,2,3},{20,30,200,40,10},{1,5,5,4,1},{4,3,2,2,5}
        });
    }

    public int[] getBiggestThree(int[][] grid){
        for (int[] ints : grid) {
            System.out.println(Arrays.toString(ints));
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] res;
        if (m < 3){
            res = new int[m];
        }else {
            res = new int[3];
        }
        //对角线之和
        int[] diagSum_left = new int[m + n - 1];
        int[] diagSum_right = new int[m + n - 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diagSum_left[i + j] += grid[i][j];
                diagSum_right[i - j + n - 1] += grid[i][j];
            }
        }
        System.out.println("left:"+Arrays.toString(diagSum_left));
        System.out.println("right:"+Arrays.toString(diagSum_right));
        return res;
    }
}
