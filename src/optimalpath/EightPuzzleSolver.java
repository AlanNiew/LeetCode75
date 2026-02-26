package optimalpath;

import java.util.*;

public class EightPuzzleSolver {
    
    static class PuzzleState implements Comparable<PuzzleState> {
        int[][] board;
        PuzzleState parent;
        String move;
        int g; // steps from start
        int h; // heuristic value
        int f; // f = g + h
        
        public PuzzleState(int[][] board, PuzzleState parent, String move) {
            this.board = new int[3][3];
            for (int i = 0; i < 3; i++) {
                this.board[i] = Arrays.copyOf(board[i], 3);
            }
            this.parent = parent;
            this.move = move;
            this.g = parent != null ? parent.g + 1 : 0;
            calculateHeuristic();
            this.f = this.g + this.h;
        }
        
        private void calculateHeuristic() {
            int[][] goal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
            h = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] != 0) {
                        int value = board[i][j] - 1;
                        int targetRow = value / 3;
                        int targetCol = value % 3;
                        h += Math.abs(targetRow - i) + Math.abs(targetCol - j);
                    }
                }
            }
        }
        
        public int[] getZeroPos() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == 0) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[]{-1, -1};
        }
        
        public List<String> getPossibleMoves() {
            List<String> moves = new ArrayList<>();
            int[] zeroPos = getZeroPos();
            int row = zeroPos[0], col = zeroPos[1];
            
            if (row > 0) moves.add("上");
            if (row < 2) moves.add("下");
            if (col > 0) moves.add("左");
            if (col < 2) moves.add("右");
            
            return moves;
        }
        
        public PuzzleState generateChild(String direction) {
            int[] zeroPos = getZeroPos();
            int row = zeroPos[0], col = zeroPos[1];
            int[][] newBoard = new int[3][3];
            
            for (int i = 0; i < 3; i++) {
                newBoard[i] = Arrays.copyOf(board[i], 3);
            }
            
            if (direction.equals("上") && row > 0) {
                newBoard[row][col] = newBoard[row-1][col];
                newBoard[row-1][col] = 0;
            } else if (direction.equals("下") && row < 2) {
                newBoard[row][col] = newBoard[row+1][col];
                newBoard[row+1][col] = 0;
            } else if (direction.equals("左") && col > 0) {
                newBoard[row][col] = newBoard[row][col-1];
                newBoard[row][col-1] = 0;
            } else if (direction.equals("右") && col < 2) {
                newBoard[row][col] = newBoard[row][col+1];
                newBoard[row][col+1] = 0;
            } else {
                return null;
            }
            
            return new PuzzleState(newBoard, this, direction);
        }
        
        public boolean isGoal() {
            int[][] goal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
            return Arrays.deepEquals(board, goal);
        }
        
        public List<String> getPath() {
            List<String> path = new ArrayList<>();
            PuzzleState current = this;
            while (current.parent != null) {
                path.add(current.move);
                current = current.parent;
            }
            Collections.reverse(path);
            return path;
        }
        
        @Override
        public int compareTo(PuzzleState other) {
            return Integer.compare(this.f, other.f);
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            PuzzleState that = (PuzzleState) obj;
            return Arrays.deepEquals(board, that.board);
        }
        
        @Override
        public int hashCode() {
            return Arrays.deepHashCode(board);
        }
        
        public void printBoard() {
            for (int[] row : board) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    
    public static boolean isSolvable(int[][] board) {
        // Flatten the board and count inversions
        List<Integer> flat = new ArrayList<>();
        for (int[] row : board) {
            for (int num : row) {
                if (num != 0) {
                    flat.add(num);
                }
            }
        }
        
        int inversions = 0;
        for (int i = 0; i < flat.size(); i++) {
            for (int j = i + 1; j < flat.size(); j++) {
                if (flat.get(i) > flat.get(j)) {
                    inversions++;
                }
            }
        }
        
        return inversions % 2 == 0;
    }
    
    public static void solvePuzzle(int[][] initialBoard) {
        if (!isSolvable(initialBoard)) {
            System.out.println("此拼图无解");
            return;
        }
        
        PriorityQueue<PuzzleState> openList = new PriorityQueue<>();
        Set<PuzzleState> closedSet = new HashSet<>();
        
        PuzzleState initialState = new PuzzleState(initialBoard, null, "");
        openList.add(initialState);
        
        while (!openList.isEmpty()) {
            PuzzleState currentState = openList.poll();
            
            if (currentState.isGoal()) {
                List<String> path = currentState.getPath();
                System.out.printf("找到最优解，共需 %d 步:\n", path.size());
                for (int i = 0; i < path.size(); i++) {
                    System.out.printf("步骤 %d: 将空格向 %s 移动\n", i+1, path.get(i));
                }
                return;
            }
            
            closedSet.add(currentState);
            
            for (String move : currentState.getPossibleMoves()) {
                PuzzleState childState = currentState.generateChild(move);
                
                if (childState == null || closedSet.contains(childState)) {
                    continue;
                }
                
                boolean found = false;
                for (PuzzleState openState : openList) {
                    if (openState.equals(childState) && openState.g <= childState.g) {
                        found = true;
                        break;
                    }
                }
                
                if (!found) {
                    openList.add(childState);
                }
            }
        }
        
        System.out.println("未找到解决方案");
    }
    
    public static void main(String[] args) {
        // 从图片中提取的初始状态
        int[][] initialBoard = {
            {4, 6, 1},
            {8, 7, 3},
            {5, 2, 0}
        };
        
        solvePuzzle(initialBoard);
    }
}