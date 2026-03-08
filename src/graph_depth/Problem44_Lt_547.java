package graph_depth;

/**
 * @author Niu
 * @date 2025-12-23
 */
public class Problem44_Lt_547 {

    public static void main(String[] args) {
        Problem44_Lt_547 problem44Lt_547 = new Problem44_Lt_547();
        int[][] isConnected = new int[][]{
                {1,0,0},
                {0,1,0},
                {0,0,1}
        };
        System.out.println(problem44Lt_547.findCircleNum(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                dfs(isConnected,visited,i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected,boolean[] visited,int i){
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(isConnected,visited,j);
            }
        }
    }
}
