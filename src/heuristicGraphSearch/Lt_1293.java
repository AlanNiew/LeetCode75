package heuristicGraphSearch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Niu
 * @date 2026-04-20
 */
public class Lt_1293 {
    public static void main(String[] args) {
        int [][] grid = {{0,0,0,0,0,0,0,0,0,0},{0,1,1,1,1,1,1,1,1,0},{0,1,0,0,0,0,0,0,0,0},{0,1,0,1,1,1,1,1,1,1},{0,1,0,0,0,0,0,0,0,0},{0,1,1,1,1,1,1,1,1,0},{0,1,0,0,0,0,0,0,0,0},{0,1,0,1,1,1,1,1,1,1},{0,1,0,1,1,1,1,0,0,0},{0,1,0,0,0,0,0,0,1,0},{0,1,1,1,1,1,1,0,1,0},{0,0,0,0,0,0,0,0,1,0}};
        System.out.println(new Lt_1293().shortestPath(grid, 1));


    }
    private static boolean containGrid(List<Grid> grids, int x, int y) {
        for (Grid grid : grids) {
            if (grid.x == x && grid.y == y) return true;
        }
        return false;
    }
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static class Grid {
        int x;
        int y;
        int f; // F = G + H - b，综合评价
        int g; // 从起点到当前格子的实际成本
        int h; // 启发式估计，到终点的曼哈顿距离
        Grid parent;

        public Grid(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /** 初始化节点的 f, g, h 值 */
        public void initGrid(Grid parent, Grid end) {
            this.parent = parent;
            this.g = (parent != null) ? parent.g + 1 : 0;
            this.h = Math.abs(this.x - end.x) + Math.abs(this.y - end.y);
            this.f = this.g + this.h;
        }
    }

    public int shortestPath(int[][] grid, int k){
        Grid start = new Grid(0,0);

        Grid end = new Grid(grid.length-1, grid[0].length-1);
        int [][] price =new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                    Grid tmp_start = new Grid(i,j);
                    // 计算一下阻碍节点到中终点的代价。
                    Grid a = aStartSearch(grid, tmp_start, end, 0,price);
                    List<Grid> path = getPath(a);
                    price[i][j] = path.size()-1;
            }
        }

        for (int[] ints : price) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        Grid resultGrid = aStartSearch(grid,start,end, k,price);
        if (resultGrid == null) {
            System.out.println("未找到路线！");
            return -1;
        }
        List<Grid> path = getPath(resultGrid);
        printPath(grid, path);
        return path.size()-1;
    };


    public Grid aStartSearch(int[][] grid,Grid start,Grid end, int k,int[][] price) {
        int m = grid.length;
        int n = grid[0].length;
        if (start.x == end.x && start.y == end.y) {
            return start;
        }

        start.initGrid(null, end);

        // 优先队列：按 f 值排序，f 相同按 h 值排序
        PriorityQueue<Grid> openList = new PriorityQueue<>(
                Comparator.comparingInt((Grid g) -> g.f)
                        .thenComparingInt(g -> g.h));
        // 使用布尔数组标记已访问状态，O(1) 查找
        boolean[][] inOpen = new boolean[m][n];
        boolean[][] inClosed = new boolean[m][n];

        openList.add(start);
        inOpen[start.x][start.y] = true;
        int count = 1;

        while (!openList.isEmpty()) {
            Grid current = openList.poll(); // O(log n) 取出最小节点
            inOpen[current.x][current.y] = false;
            inClosed[current.x][current.y] = true;

            // 遍历四个方向的邻居
            for (int[] dir : DIRECTIONS) {
                int nextX = current.x + dir[0];
                int nextY = current.y + dir[1];
                if (!isValid(grid,nextX, nextY, inOpen, inClosed)) continue;
                Grid neighbor = new Grid(nextX, nextY);
                neighbor.initGrid(current, end);
                // 碰到阻碍,尝试消除
                if (grid[nextX][nextY] == 1){
                    // 尝试消除看一下代价
                    if (k>0){
                        int cur_price = price[current.x][current.y];
                        int next_price = price[nextX][nextY];
                        System.out.println("当前节点:(" + current.x + "," + current.y + ")代价为："+cur_price+"\n下个阻碍节点:（"+neighbor.x+","+neighbor.y+"）代价："+next_price);
                        System.out.println("代价差异"+Math.abs(cur_price-next_price));
                    }
                    continue;
                }

                // 到达终点直接返回
                if (nextX == end.x && nextY == end.y) {
                    return neighbor;
                }
                openList.add(neighbor);
                inOpen[nextX][nextY] = true;
            }
        }

        return null;
    }

    private static boolean isValid(int [][] grid,int x, int y, boolean[][] inOpen, boolean[][] inClosed) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return false;
        return !inOpen[x][y] && !inClosed[x][y];
    }

    private List<Grid> getPath(Grid resultGrid){
        // 回溯获取路径
        List<Grid> path = new ArrayList<>();
        while (resultGrid != null) {
            path.add(resultGrid);
            resultGrid = resultGrid.parent;
        }
        return path;
    }

    private void printPath(int [][] grid,List<Grid> path){
        // 打印迷宫及路径
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (containGrid(path, i, j)) {
                    System.out.print("*, ");
                } else {
                    System.out.print(grid[i][j] + ", ");
                }
            }
            System.out.println();
        }
        System.out.println("共走" + (path.size() - 1) + "步！");
    }
}
