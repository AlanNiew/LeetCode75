package heuristicGraphSearch;

import java.util.*;

/**
 * @author Niu
 * @date 2026-04-20
 */
public class Lt_773 {

    public static void main(String[] args) {
        System.out.println(new Lt_773().slidingPuzzle(new int[][]{
                {2,1,0},{4,6,5},{8,7,3}
        }));
    }
    // 2. 预计算每个位置在一维字符串中的邻居索引（3x3 网格）
    private static final int[][] neighbor = {
            {1, 3},       // 0
            {0, 2, 4},    // 1
            {1, 5},       // 2
            {0, 4, 6},    // 3
            {1, 3, 5, 7}, // 4
            {2, 4, 8},    // 5
            {3, 7},       // 6
            {4, 6, 8},    // 7
            {5, 7}        // 8
    };

    public int slidingPuzzle(int[][] board) {
        // 1. 将二维数组转换成字符串作为初始状态
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        String target = "123456780";
//        Node resNode = bfs(start, target);
        Node resNode = aStart(start, target);
        List<Node> path = new ArrayList<>();
        while (resNode != null) {
            path.add(resNode);
            resNode = resNode.parent;
        }
        Collections.reverse(path);
        int ans = path.size() - 1;
        for (int i = 0; i < ans; i++) {
            Node cur = path.get(i);
            Node next = path.get(i + 1);
            System.out.print("由（"+cur.row+","+cur.col+"）向");
            if(cur.row > next.row){
                System.out.print(" 上 ");
            }
            if(cur.row < next.row){
                System.out.print(" 下 ");
            }
            if(cur.col > next.col){
                System.out.print(" 左 ");
            }
            if(cur.col < next.col){
                System.out.print(" 右 ");
            }
            System.out.println("移动到（"+next.row+","+next.col+"）");
        }
        System.out.println("共"+ans+"步");
        return ans;
    }

    private Node bfs(String start,String target){
        // 3. BFS 初始化
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new Node(start,null));
        visited.add(start);
        // 4. 开始 BFS 搜索
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur.state.equals(target)) {
                    return cur;
                }
                // 找0
                int zeroIndex = cur.state.indexOf("0");
                // 尝试与邻居交换
                for (int idx : neighbor[zeroIndex]) {
                    String tmp = swap(cur.state, idx, zeroIndex);
                    // 尝试交换
                    if (!visited.contains(tmp)) {
                        queue.offer(new Node(tmp,cur));
                        visited.add(tmp);
                    }
                }
            }
        }
        return null;
    }
    // 交换字符串中两个位置的字符，生成新字符串
    private String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }


    class Node {
        String state;
        int g;   // 实际步数
        int h;   // 启发值
        int row;
        int col;
        Node parent;

        public Node(String state,Node p) {
            this.state = state;
            int i = state.indexOf("0");
            row = i/3;
            col = i%3;
            parent = p;
        }

        Node(String state, int g, int h, Node p) {
            this.state = state;
            this.g = g;
            this.h = h;
            int i = state.indexOf("0");
            row = i/3;
            col = i%3;
            parent = p;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "state='" + state + '\'' +
                    ", g=" + g +
                    ", h=" + h +
                    ", row=" + row +
                    ", col=" + col +
                    ", parent=" + parent +
                    '}';
        }
    }

    private Node aStart(String start, String target){
        // 优先队列，按 f = g + h 排序
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.g + a.h));
        // 记录每个状态已经到达的最小 g 值
        Map<String, Integer> bestG = new HashMap<>();

        pq.offer(new Node(start, 0, h(start),null));
        bestG.put(start, 0);

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.state.equals(target)) {
                return cur;
            }
            // 如果当前节点的 g 值大于记录的最小 g 值，则跳过（已经处理过更优的）
            if (cur.g > bestG.getOrDefault(cur.state, Integer.MAX_VALUE)) {
                continue;
            }
            // 扩展邻居
            int zeroPos = cur.state.indexOf("0");

            for (int idx : neighbor[zeroPos]) {
                String nextState = swap(cur.state, idx, zeroPos);
                int nextG = cur.g+1;
                if (nextG<bestG.getOrDefault(nextState, Integer.MAX_VALUE)) {
                    bestG.put(nextState, nextG);
                    pq.offer(new Node(nextState, nextG, h(nextState),cur));
                }
            }
        }
        return null;
    }

    private int h(String state) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            char ch = state.charAt(i);
            if (ch == '0') continue;
            int num = ch - '0';          // 数字 1..8
            // 目标位置映射（一维索引转二维坐标）
            int targetRow = (num - 1) / 3;
            int targetCol = (num - 1) % 3;
            int curRow = i / 3;
            int curCol = i % 3;
            sum += Math.abs(curRow - targetRow) + Math.abs(curCol - targetCol);
        }
        return sum;
    }
}
