package interval;

/**
 * @author Niu
 * @date 2026-05-13
 */
public class Problem72_Lt435 {
    public static void main(String[] args) {
//        int [][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        int [][] intervals = {{1,2},{2,3}};
        System.out.println(new Problem72_Lt435().eraseOverlapIntervals(intervals));
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        // 判断不重叠区间
        int right = intervals[0][1];
        int len = intervals.length;
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] >= right) {
                count++;
                right = intervals[i][1];
            }
        }
        return len-count;
    }
}
