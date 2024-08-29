package path.algorithms;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/25 17:27
 */
public class LC_64 {

    /**
     * 最小路径和
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] flag = new int[m][n];
        int price = grid[0][0];
        int startX = 0;
        int startY = 0;
        while (startX < m && startY < n){
            int[] neighborIndex = getNeighborIndex(grid, startX, startY);
        }
        return price;
    }
    //获取邻居最小代价下标
    private int[] getNeighborIndex(int[][] grid,int x,int y){
        //上
        int up = getNeighborPrice(grid, x, y - 1);
        //下
        int dow = getNeighborPrice(grid,x,y+1);
        //左
        int left = getNeighborPrice(grid,x-1,y);
        //右
        int right = getNeighborPrice(grid,x+1,y);
        //取最小的坐标和代价返回
        if (up < dow && up < left && up < right){
            return new int[]{x,y-1};
        }else if (dow < up && dow < left && dow < right){
            return new int[]{x,y+1};
        }else if (left < up && left < dow && left < right){
            return new int[]{x-1,y};
        }else {
            return new int[]{x+1,y};
        }
    }

    //判断某个坐标邻居的代价
    private int getNeighborPrice(int[][] grid,int x,int y){
        int price = 0;
        //边界判断
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length){
            return Integer.MAX_VALUE;
        }
        //上下左右
        if (x > 0 && y > 0){
            price = grid[x-1][y-1];
        }else if (x > 0){
            price = grid[x-1][y];
        }else if (y > 0){
            price = grid[x][y-1];
        }
        return price;
    }
}
