package optimalpath;

import java.util.*;

public class Puzzle8AStar {

    private static final int[] GOAL = {1, 2, 3, 4, 5, 6, 7, 8, 0};

    // 方向：上、下、左、右
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    public static List<int[]> solve(int[] start) {
        int zeroIndex = -1;
        for (int i = 0; i < 9; i++)
            if (start[i] == 0) {
                zeroIndex = i;
                break;
            }

        PriorityQueue<Node> open = new PriorityQueue<>(Comparator.comparingInt(Node::f));
        Map<Node, Integer> gMap = new HashMap<>();
        Node root = new Node(start, 0, zeroIndex, null);
        open.add(root);
        gMap.put(root, 0);

        while (!open.isEmpty()) {
            Node cur = open.poll();
            if (Arrays.equals(cur.board, GOAL)) {
                LinkedList<int[]> path = new LinkedList<>();
                for (Node n = cur; n != null; n = n.parent)
                    path.addFirst(n.board.clone());
                return path;
            }

            int x = cur.zeroIndex / 3;
            int y = cur.zeroIndex % 3;

            for (int d = 0; d < 4; d++) {
                int nx = x + DX[d], ny = y + DY[d];
                if (nx < 0 || nx > 2 || ny < 0 || ny > 2) continue;

                int newZero = nx * 3 + ny;
                int[] newBoard = cur.board.clone();
                newBoard[cur.zeroIndex] = newBoard[newZero];
                newBoard[newZero] = 0;

                Node next = new Node(newBoard, cur.g + 1, newZero, cur);
                Integer oldG = gMap.get(next);
                if (oldG == null || next.g < oldG) {
                    gMap.put(next, next.g);
                    open.add(next);
                }
            }
        }
        return null; // 无解
    }

    // -------------- 测试 --------------
    public static void main(String[] args) {
        int[] start = {0, 4, 8, 1, 5, 6, 7, 3, 2};
        List<int[]> path = solve(start);
        if (path == null) {
            System.out.println("无解");
            return;
        }
        System.out.println("最短步数：" + (path.size() - 1));
        for (int[] s : path) {
            for (int i = 0; i < 9; i += 3)
                System.out.println(Arrays.toString(Arrays.copyOfRange(s, i, i + 3)));
            System.out.println("------");
        }
    }

    // 节点类
    private static class Node {
        int[] board;
        int g, h, zeroIndex;
        Node parent;

        Node(int[] board, int g, int zeroIndex, Node parent) {
            this.board = board.clone();
            this.g = g;
            this.h = computeH(board);
            this.zeroIndex = zeroIndex;
            this.parent = parent;
        }

        // 曼哈顿 + 线性冲突
        private static int computeH(int[] b) {
            int dist = 0;
            for (int i = 0; i < 9; i++) {
                if (b[i] == 0) continue;
                int goal = b[i] - 1;
                dist += Math.abs(i / 3 - goal / 3) + Math.abs(i % 3 - goal % 3);
            }
            // 线性冲突
            dist += linearConflict(b);
            return dist;
        }

        private static int linearConflict(int[] b) {
            int extra = 0;
            // 行
            for (int row = 0; row < 3; row++) {
                int max = -1;
                for (int col = 0; col < 3; col++) {
                    int val = b[row * 3 + col];
                    if (val != 0 && (val - 1) / 3 == row) {
                        if (val > max) {
                            max = val;
                        } else {
                            extra += 2;
                        }
                    }
                }
            }
            // 列
            for (int col = 0; col < 3; col++) {
                int max = -1;
                for (int row = 0; row < 3; row++) {
                    int val = b[row * 3 + col];
                    if (val != 0 && (val - 1) % 3 == col) {
                        if (val > max) {
                            max = val;
                        } else {
                            extra += 2;
                        }
                    }
                }
            }
            return extra;
        }

        int f() {return g + h;}

        @Override
        public boolean equals(Object o) {
            return Arrays.equals(board, ((Node) o).board);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(board);
        }
    }
}
