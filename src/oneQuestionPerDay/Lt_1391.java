package oneQuestionPerDay;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Niu
 * @date 2026-04-27
 */
public class Lt_1391 {

    public static void main(String[] args) {

    }

    public boolean hasValidPath(int[][] grid) {
        Map<Integer,int [][]> directions=new HashMap<>(); //x,y
        directions.put(1,new int[][]{{-1,0},{1,0}});
        directions.put(2,new int[][]{{0,1},{0,-1}});
        directions.put(3,new int[][]{{-1,0},{0,1}});
        directions.put(4,new int[][]{{1,0},{0,1}});
        directions.put(5,new int[][]{{-1,0},{0,-1}});
        directions.put(6,new int[][]{{1,0},{0,-1}});
        //1 左侧，4，6，右侧 3，5
        //2 上，3，4，下 5，6
        //3，左侧 4，6 下 5，6
        // 沿着方向走
        int row=grid.length;
        int col=grid[0].length;
        boolean[][] visited=new boolean[row][col];
        int curX = 0;
        int curY = 0;
        while (true){
            if(curX==row-1&&curY==col-1){
                return true;
            }
            int n = grid[curY][curX];
            int[][] direction = directions.get(n);
            // 有一个是入口，另一个肯定是出口



//            for (int i = 0; i < 2; i++) {
//                int dir_x = direction[i][0];
//                int dir_y = direction[i][1];
//                int nextX = curX + dir_x;
//                int nextY = curY + dir_y;
//                // 看看可以走过去不
//                if (visited[nextX][nextY]==true){continue;}
//                int next = grid[nextX][nextY];
//                int[][] nextDir = directions.get(next);
//
//            }
        }
//        return true;
    }
}
