package graph_breadth;

import java.util.*;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/11/16 17:40
 */
public class Problem47_Lt1926 {
    public static void main(String[] args) {
        Problem47_Lt1926 problem47Lt_1926 = new Problem47_Lt1926();
        char [][] maze = new char[][]{
                {'+','+','.','+'},
                {'.','.','.','+'},
                {'+','+','+','.'}
        };
        int [] entrance = new int[]{1,2};
        System.out.println(problem47Lt_1926.nearestExit(maze, entrance));
    }
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 1926. 迷宫离入口最近的出口
     * @param maze
     * @param entrance
     * @return
     */
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        int [][]visited = new int[maze.length][maze[0].length];
        // 从出口开始走
        queue.offer(entrance);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 尝试向四周走一步
            step++;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                // 遍历四周，查询出口位置
                for (int[] direction : DIRECTIONS) {
                    int nextX = poll[0] + direction[0]; // x
                    int nextY = poll[1] + direction[1]; // y
                    // 判断下一步是否超出边界
                    if (nextX >= 0 && nextX < maze.length && nextY >= 0 && nextY < maze[0].length) {
                        // 判断是否可走
                        int[] curLocation = {nextX, nextY};
                        if (maze[nextX][nextY] == '.' && visited[nextX][nextY] == 0) {
                            System.out.println(poll[0]+","+poll[1] +" -> "+Arrays.toString(curLocation));
                            queue.offer(curLocation);
                            visited[nextX][nextY] = 1;
                            // 判断是否走到出口了
                            if (isExport(nextX,nextY,maze,entrance)) {
                                // 走到出口了
                                return step;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    private boolean isExport(int x, int y,char[][] maze,int[] entrance) {
        int rowLen = maze.length;
        int lineLen = maze[0].length;
        if (x == entrance[0] && y == entrance[1]) {
            return false;
        }
        if (maze[x][y] == '.') {
            // 是否到边界了
            return x == 0 || y == lineLen - 1 || x == rowLen - 1 || y == 0;
        }
        return false;
    }

    public Set<int []> isExistExit(char[][] maze,int[] entrance){
        int rowLen = maze.length;
        int lineLen = maze[0].length;
        Set<int []> ans = new HashSet<>();
        //遍历边界，寻找出口
        for (int i = 0; i < rowLen; i++) {
            if (i == 0 || i== rowLen -1){
                //全部查看
                for (int j = 0; j < lineLen; j++){
                    char c = maze[i][j];
                    if (c == '.' && !(entrance[0] == i && entrance[1] == j)){
                        ans.add(new int[]{i,j});
                    }
                }
            } else {
                char lenStart = maze[i][0];
                char lenEnd = maze[i][lineLen - 1];
                if (lenStart == '.' && !(entrance[0] == i && entrance[1] == 0)){
                    ans.add(new int[]{i, 0});
                }
                if (lenEnd == '.' && !(entrance[0] == i && entrance[1] == lineLen - 1)){
                    ans.add(new int[]{i, lineLen - 1});
                }
            }
        }
        return ans;
    }

    //打印迷宫
    public void printMaze(char[][] maze){
        for (char[] chars : maze) {
            for (char aChar : chars) {
                System.out.print(aChar+" ");
            }
            System.out.println();
        }
    }
}
