package binarySearch;

/**
 * @author Niu
 * @date 2026-03-17
 */
public class Problem56_Lt875 {
    public static void main(String[] args) {
        int [] arras = new int[]{30,11,23,4,20};
        int h = 6;
        System.out.println(new Problem56_Lt875().minEatingSpeed(arras, h));
    }
    public int minEatingSpeed(int[] piles, int h) {
        // 二分查找，计算均值，在满足h 刚好吃掉香蕉，并且数字不是很大
        int len = piles.length;
        int ans = 0;
        int max = -1;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        // 最大一堆找到了
        int left = 1, right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long count = 0;
            for (int pile : piles) {
                count += (pile + mid - 1) / mid;
            }
            if (count <= h) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
