package oneQuestionPerDay;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Author:Niu
 * Date:2024/11/23 16:57
 */
public class Lt_1926 {

    /**
     * 1926.迷宫escape
     *给你一个mxn的迷宫知阵 maze(下标从0开始)，矩阵中有空格子(用·.·表示)和墙(用'+'表示)。
     * 同时给你迷宫的入口entrance，用entrance =[entrancerow，entrancecol]表示你一开始所在格了的行和列。
     * 每一步操作，你可以往 上，下，左 或者 右 移动一个格子。你不能进入墙所在的格子
     * 你也不能离开迷宫。你的目标是找到离 entrance 最近 的出口。出口的含义是 maze 边界 上的空格子。entrance 格子 不算 出口。
     * 请你返回从 entrance 到最近出口的最短路径的 步数，如果不存在这样的路径，请你返回 -1
     *
     * @param maze 二维数组
     * @param entrance 入口
     * @return
     */
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Set<int[]> existExit = existExit(maze);
        //遍历所有出口，找到可以到达且距离最小。
        int min = Integer.MAX_VALUE;
        int [] curPoint;
        for (int[] exit : existExit) {
            //判断是否为入口
            if (Arrays.equals(exit, entrance)){
                continue;
            }

        }
        System.out.println("出口："+existExit.stream().map(Arrays::toString).collect(Collectors.toList()));
        return 0;
    }

    private int[] isCome(char[][] maze, int[] cur, int[] target){
        int curX = cur[0];
        int curY = cur[1];
        //确定大致方向
        int targetX = target[0];
        int targetY = target[1];
        boolean isLeft = curX - targetX > 0;
        boolean isUp = curY - targetY > 0;
        int nextX = curX,nextY = curY;
        if (isLeft){
            nextX -= 1;
        }else {
            nextX += 1;
        }
        if (isUp){
            nextY -= 1;
        }else {
            nextY += 1;
        }
        //尝试向左走一步
        if (curY - 1 >= 0 && maze[curX][curY - 1] == '.'){
            return new int[]{curX, curY - 1};
        }
        //尝试向右走一步
        if (curY + 1 < maze[0].length && maze[curX][curY + 1] == '.'){
            return new int[]{curX, curY + 1};
        }
        //尝试向上走一步
        if (curX - 1 >= 0 && maze[curX - 1][curY] == '.'){
            return new int[]{curX - 1, curY};
        }
        //尝试向下走一步
        if (curX + 1 < maze.length && maze[curX + 1][curY] == '.'){
            return new int[]{curX + 1, curY};
        }
        return null;
    }


    private Set<int []> existExit(char[][] maze){
        //寻找所有出口
        Set<int []> result = new HashSet<>();
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == '.' && (i == 0 || j == 0 || i == maze.length - 1 || j == maze[0].length - 1)){
                    result.add(new int[]{i,j});
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] maze = {{'+','+','.','+'},
                {'.','.','.','+'},
                {'+','+','+','.'}};
//maze = [["+","+","+"],[".",".","."],["+","+","+"]],
        char[][] maze1 = {{'+','+','+'},{'.','.','.'},{'+','+','+'}};
//打印地图
        for (char[] chars : maze1) {
            for (char aChar : chars) {
                System.out.print(aChar+" ");
            }
            System.out.println();
        }
        int[] entrance = {1,2};
        System.out.println(new Lt_1926().nearestExit(maze1, entrance));
    }
}
