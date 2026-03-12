package graph_breadth;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 994. 腐烂的橘子
 *
 * 题目描述：
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * - 值 0 代表空单元格
 * - 值 1 代表新鲜橘子
 * - 值 2 代表腐烂的橘子
 *
 * 每分钟，腐烂的橘子周围 4 个方向上相邻的新鲜橘子都会腐烂。
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 *
 * 解题思路：
 * 使用 BFS（广度优先搜索），因为腐烂是同时从多个源头向四周扩散的。
 * 1. 首先将所有腐烂的橘子加入队列作为初始层
 * 2. 每分钟处理当前层的所有腐烂橘子，将它们周围的新鲜橘子腐烂并加入下一层
 * 3. 按层遍历，层数即为分钟数
 *
 * 时间复杂度：O(m * n)，每个橘子最多被访问一次
 * 空间复杂度：O(m * n)，队列最坏情况存储所有橘子
 *
 * @author Niu
 * @date 2026-03-12
 */
public class Problem48_Lt994 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {2, 1, 1},
                {1, 1, 1},
                {0, 1, 2}
        };
        System.out.println(new Problem48_Lt994().orangesRotting(grid)); // 预期输出: 2
    }

    // 方向数组：上、下、左、右
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // 遍历网格，统计新鲜橘子数量，并将腐烂橘子加入队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // 没有新鲜橘子，直接返回 0
        if (freshCount == 0) {
            return 0;
        }

        // 没有腐烂橘子但有新鲜橘子，不可能腐烂
        if (queue.isEmpty()) {
            return -1;
        }

        int minutes = 0;

        // BFS 按层遍历
        while (!queue.isEmpty()) {
            int size = queue.size();

            // 处理当前层的所有腐烂橘子
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                // 向四个方向扩散
                for (int[] dir : DIRECTIONS) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    // 检查边界和是否是新鲜橘子
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        freshCount--;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }

            // 处理完一层后，如果队列不为空，说明有新的橘子腐烂，分钟数+1
            if (!queue.isEmpty()) {
                minutes++;
            }
        }

        // 打印最终矩阵
        System.out.println("腐烂后的矩阵：");
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }

        // 如果还有新鲜橘子没被腐烂，返回 -1
        return freshCount == 0 ? minutes : -1;
    }
}
