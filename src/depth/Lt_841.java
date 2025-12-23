package depth;

import java.util.List;

/**
 * @author Niu
 * @date 2025-12-23
 */
public class Lt_841 {

    public static void main(String[] args) {
        Lt_841 lt_841 = new Lt_841();
        List<List<Integer>> rooms = List.of(List.of(1,3), List.of(3,0,1), List.of(2), List.of(0));

        System.out.println(lt_841.canVisitAllRooms(rooms));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(rooms, visited, 0);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public void dfs(List<List<Integer>> rooms, boolean[] visited, int i) {
        for (int j : rooms.get(i)) {
            if (!visited[j]) {
                visited[j] = true;
                dfs(rooms, visited, j);
            }
        }
    }
}
