package heuristicGraphSearch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A* 寻路算法实现
 * @author Niu
 * @date 2026-04-16
 */
public class Main {

    // 迷宫地图：0表示可走，1表示障碍
    private static final int[][] MAZE = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
    };

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    // 四个移动方向：右、左、下、上
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * 网格节点
     */
    public static class Grid {
        int x;
        int y;
        int f; // F = G + H，综合评价
        int g; // 从起点到当前格子的实际成本
        int h; // 启发式估计，到终点的曼哈顿距离
        Grid parent;
        int randomOrder; // 用于 f 和 h 相同时的随机打破平局

        public Grid(int x, int y) {
            this.x = x;
            this.y = y;
            this.randomOrder = RANDOM.nextInt();
        }

        /** 初始化节点的 f, g, h 值 */
        public void initGrid(Grid parent, Grid end) {
            this.parent = parent;
            this.g = (parent != null) ? parent.g + 1 : 0;
            this.h = Math.abs(this.x - end.x) + Math.abs(this.y - end.y);
            this.f = this.g + this.h;
        }
    }

    /**
     * A* 寻路算法
     * @param start 起点
     * @param end   终点
     * @return 到达终点的节点（可通过 parent 回溯路径），若无可达路径返回 null
     */
    public static Grid aStarSearch(Grid start, Grid end) {
        if (start.x == end.x && start.y == end.y) {
            return start;
        }

        start.initGrid(null, end);

        // 优先队列：按 f 值排序，f 相同按 h 值排序，都相同随机选择
        PriorityQueue<Grid> openList = new PriorityQueue<>(
                Comparator.comparingInt((Grid g) -> g.f)
                        .thenComparingInt(g -> g.h)
                        .thenComparingInt(g -> g.randomOrder));
        // 使用布尔数组标记已访问状态，O(1) 查找
        boolean[][] inOpen = new boolean[MAZE.length][MAZE[0].length];
        boolean[][] inClosed = new boolean[MAZE.length][MAZE[0].length];

        openList.add(start);
        inOpen[start.x][start.y] = true;
        int count = 1;

        while (!openList.isEmpty()) {
            Grid current = openList.poll(); // O(log n) 取出最小节点
            inOpen[current.x][current.y] = false;
            inClosed[current.x][current.y] = true;
            System.out.println("第" + count++ + "轮搜索，选择格子为：(" + current.x + "," + current.y + ")");

            // 遍历四个方向的邻居
            for (int[] dir : DIRECTIONS) {
                int nextX = current.x + dir[0];
                int nextY = current.y + dir[1];
                if (!isValid(nextX, nextY, inOpen, inClosed)) continue;
                Grid neighbor = new Grid(nextX, nextY);
                neighbor.initGrid(current, end);
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

    /** 验证格子是否可走 */
    private static boolean isValid(int x, int y, boolean[][] inOpen, boolean[][] inClosed) {
        if (x < 0 || x >= MAZE.length || y < 0 || y >= MAZE[0].length) return false;
        if (MAZE[x][y] == 1) return false;
        return !inOpen[x][y] && !inClosed[x][y];
    }

    public static void main(String[] args) {
        // 设置起点和终点
        Grid startGrid = new Grid(0, 0);
        Grid endGrid = new Grid(4, 6);
        // A* 搜索终点
        Grid resultGrid = aStarSearch(startGrid, endGrid);
        if (resultGrid == null) {
            System.out.println("未找到路线！");
            return;
        }
        // 回溯获取路径
        List<Grid> path = new ArrayList<>();
        while (resultGrid != null) {
            path.add(resultGrid);
            resultGrid = resultGrid.parent;
        }
        // 打印迷宫及路径
        for (int i = 0; i < MAZE.length; i++) {
            for (int j = 0; j < MAZE[0].length; j++) {
                if (containGrid(path, i, j)) {
                    System.out.print("*, ");
                } else {
                    System.out.print(MAZE[i][j] + ", ");
                }
            }
            System.out.println();
        }
        System.out.println("共走" + (path.size() - 1) + "步！");
    }

    private static boolean containGrid(List<Grid> grids, int x, int y) {
        for (Grid grid : grids) {
            if (grid.x == x && grid.y == y) return true;
        }
        return false;
    }
}
