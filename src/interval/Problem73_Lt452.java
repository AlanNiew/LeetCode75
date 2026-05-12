package interval;

import java.util.Arrays;

/**
 * @author Niu
 * @date 2026-05-12
 */
public class Problem73_Lt452 {
    public static void main(String[] args) {
//        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
//        int[][] points = {{1,2}, {3, 4}, {5, 6}, {7, 8}};
        int[][] points = {{-2147483646,-2147483645}, {2147483646,2147483647}};
        System.out.println(new Problem73_Lt452().findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {
        // 查找重合区间
        // 排序，Integer.compare 避免溢出
        Arrays.sort(points, (a,b)->Integer.compare(a[1],b[1]));
        int ans = 0;
        int pre=Integer.MIN_VALUE;
        for (int[] point : points) {
            if (point[0] > pre) {
                ans++;
                pre = point[1];
            }
        }
        return ans;
    }
}
