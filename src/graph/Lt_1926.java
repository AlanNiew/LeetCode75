package graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/11/16 17:40
 */
public class Lt_1926 {
    public static void main(String[] args) {
        Lt_1926 lt_1926 = new Lt_1926();
        char [][] maze = new char[][]{
                {'+','+','.','+'},
                {'.','.','.','+'},
                {'+','+','+','.'}
        };
        int [] entrance = new int[]{1,2};
        lt_1926.nearestExit(maze,entrance);
    }

    /**
     * 1926. 迷宫离入口最近的出口
     * @param maze
     * @param entrance
     * @return
     */
    public int nearestExit(char[][] maze, int[] entrance) {
        //寻找是存在出口
        printMaze(maze);
        Set<int[]> existExit = isExistExit(maze, entrance);
        for (int[] ints : existExit) {
            System.out.println(Arrays.toString(ints));
        }
        return 0;
    }

    public Set<int []> isExistExit(char[][] maze,int[] entrance){
        int rowLen = maze.length;
        int lineLen = maze[0].length;
        Set<int []> ans = new HashSet<>();
        int [] queryRow = new int[]{0,rowLen-1};
        int [] queryLine = new int[]{0,lineLen-1};
        int count = 0;
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
            }else {
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
