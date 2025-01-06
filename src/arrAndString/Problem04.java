package arrAndString;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/2 18:33
 */
public class Problem04 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPlaceFlowers(new int[]{0,0,1,0,0}, 1));
    }

    static class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int index = 0,len = flowerbed.length;
            while (n > 0 && index < len){
                int b = flowerbed[index];
                if (b != 0) {
                    index++;
                    continue;
                }
                int a = (index == 0) ? 0 : flowerbed[index - 1];
                int c = (index == len - 1) ? 0 : flowerbed[index + 1];
                if (a==0 && c==0){
                    n--;
                    index = index+1;
                }
                index++;
            }
            return n==0;
        }
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] a = new int[flowerbed.length + 2];
        System.arraycopy(flowerbed, 0, a, 1, flowerbed.length);
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i - 1] == 0 && a[i] == 0 && a[i + 1] == 0) {
                a[i] = 1; // 种花！
                n--;
            }
        }
        return n <= 0;
    }

}
