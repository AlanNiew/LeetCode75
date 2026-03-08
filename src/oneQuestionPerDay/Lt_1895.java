package oneQuestionPerDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Niu
 * @date 2026-01-18
 */
public class Lt_1895 {
    public static void main(String[] args) {
        int[][] grid = {{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}};
        System.out.println(new Lt_1895().largestMagicSquare(grid));
    }

    public int largestMagicSquare(int[][] grid) {
        // 前缀和
        int m = grid.length; // row
        int n = grid[0].length; // col
        List<int[][]> colSumList = new ArrayList<>();
        List<int[][]> rowSumList = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            int[][] colSum = new int[m + 1][n + 1];
            for (int j = i; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    colSum[j][k] = colSum[j-1][k] + grid[j-1][k-1];
                }
            }
            colSumList.add(colSum);
        }
        for (int i = 1; i <= n; i++) {
            int[][] rowSum = new int[m + 1][n + 1];
            for (int j = i; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    rowSum[k][j] = rowSum[k][j-1] + grid[k-1][j-1];
                }
            }
            rowSumList.add(rowSum);

        }

//        for (int[][] ints : colSumList) {
//            for (int[] anInt : ints) {
//                System.out.println(Arrays.toString(anInt));
//            }
//            System.out.println("--------");
//        }
//        System.out.println("--------rowList------");
//        for (int[][] ints : rowSumList) {
//            for (int[] anInt : ints) {
//                System.out.println(Arrays.toString(anInt));
//            }
//            System.out.println("--------");
//        }
        System.out.println(rowSumList.size());
        System.out.println(colSumList.size());
        int min = Math.min(m, n);
        for (int i = 0; i < min; i++) {
            System.out.println("i = " + i);
            int[][] rowSum = rowSumList.get(i);
            int[][] colSum = colSumList.get(i);
            printArray(rowSum);
            System.out.println("--------");
            printArray(colSum);
            System.out.println("--------");
            int rowSumEqual = findRowSumEqual(rowSum, i, colSum);
            System.out.println("rowSumEqual = " + rowSumEqual);
        }
        return 0;
    }

    public void printArray(int[][] arr) {
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }
    public int findRowSumEqual(int[][] rows,int index,int[][] cols){
        int min = Math.min(rows.length, rows[0].length);
        for (int i = index+1; i < min; i++) {
            for (int j = index+1 ; j < min; j++) {
                if (rows[i][j] == cols[j][i]){
                    System.out.println("i = " + i + ", j = " + j);
                    System.out.println("rows[i][j] = " + rows[i][j]);
                }
            }
        }
        return 0;
    }
}
