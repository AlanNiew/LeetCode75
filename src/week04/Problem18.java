package week04;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/20 20:25
 */
public class Problem18 {

    /**
     * 1732. 找到最高海拔
     * @param gain
     * @return
     */
    public int largestAltitude(int[] gain) {
        int res = 0;
        int elevation = 0;
        for (int i : gain) {
            elevation += i;
            if (elevation > res) {
                res = elevation;
            }
        }
        return res;
    }

}
