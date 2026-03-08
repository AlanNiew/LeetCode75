package graph_depth;

import java.util.ArrayList;
import java.util.List;

public class Problem45_Lt_1466 {


    public static void main(String[] args) {
        Problem45_Lt_1466 problem45Lt_1466 = new Problem45_Lt_1466();
        System.out.println(problem45Lt_1466.minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}));
    }

    /**
     * 1466. 重新规划路线
     * 计算最少需要反转多少条边，使得所有节点都能到达节点 0
     * @param n 节点数量
     * @param connections 边的连接关系，connections[i] = [ai, bi] 表示从 ai 到 bi 的有向边
     * @return 最少需要反转的边数
     */
    public int minReorder(int n, int[][] connections) {
        // 构建邻接表，graph.get(i) 存储节点 i 的所有邻居及边的权重
        // int[]{neighbor, weight}: weight=1 表示原方向（需要反转），weight=0 表示反向（无需操作）
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 遍历所有边，构建无向图（但通过权重标记原始方向）
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            // 原方向边，权重为 1：如果需要走这条边，说明需要反转
            graph.get(from).add(new int[]{to, 1});
            // 反向边，权重为 0：如果可以走这条边，说明无需反转
            graph.get(to).add(new int[]{from, 0});
        }
        
        // 从节点 0 开始 DFS，-1 表示根节点没有父节点
        return dfs(0, -1, graph);
    }

    /**
     * 深度优先搜索，统计以 node 为根的子树中需要反转的边数
     * @param node 当前节点
     * @param parent 父节点（用于避免走回头路）
     * @param graph 邻接表
     * @return 以 node 为根的子树中需要反转的边数
     */
    private int dfs(int node, int parent, List<List<int[]>> graph) {
        int count = 0;  // 记录当前子树需要反转的边数
        
        // 遍历当前节点的所有邻居
        for (int[] neighbor : graph.get(node)) {
            int next = neighbor[0];      // 邻居节点
            int weight = neighbor[1];    // 边的权重：1=需要反转，0=无需反转
            
            // 避免走回父节点
            if (next != parent) {
                // 累加当前边的权重 + 子树的结果
                count += weight + dfs(next, node, graph);
            }
        }
        
        return count;
    }

}
