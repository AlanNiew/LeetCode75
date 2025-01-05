package oneQuestionPerDay;

/**
 * Author:Niu
 * Data:2024/10/4 10:58
 */
public class Lt_1266 {
    public static void main(String[] args) {
        Lt_1266 lt_1266 = new Lt_1266();
        System.out.println("最短路径："+lt_1266.minDistance(1, 1, 3, 4));
    }
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            ans += minDistance(points[i - 1][0], points[i - 1][1], points[i][0], points[i][1]);
        }
        return ans;
    }
    // 寻找最短路径
    public int minDistance(int x1 , int y1 , int x2 , int y2) {
        //可走对角线
        return Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
    }
}
