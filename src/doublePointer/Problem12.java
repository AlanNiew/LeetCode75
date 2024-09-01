package doublePointer;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/8 19:11
 */
public class Problem12 {

    /**
     * 盛水最多的容器
     * @param height 高度
     * @return 最大容量
     */
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = calculateArea(height, left, right);
            if (area > max) {
                max = area;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    //计算面积
    private int calculateArea(int[] height, int left, int right) {
        int minHeight = Math.min(height[left], height[right]);
        return (right - left) * minHeight;
    }

}
