package oneQuestionPerDay;

import java.util.Arrays;

/**
 * @author Niu
 * @date 2026-02-25
 */
public class Lt_1356 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(new Lt_1356().sortByBits(arr)));
    }
    public int[] sortByBits1(int[] arr) {
        int len = arr.length;
        boolean[][] tmp_arr = new boolean[14][len];
        Arrays.sort(arr);
        for (int i = 0; i < len; i++) {
            int n = arr[i];
            int bitCount = Integer.bitCount(n);
            tmp_arr[bitCount][i] = true;
        }
        int [] res = new int[len];
        int index = 0;
        for (boolean[] ints : tmp_arr) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j]) {
                    res[index++] = arr[j];
                }
            }
        }
        return res;
    }

    public int[] sortByBits(int[] arr) {
        //10^4<2^14
        for (int i = 0; i < arr.length; i++) {
            int i1 = Integer.bitCount(arr[i]) << 14;
            arr[i] |= i1;
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            arr[i] &= (1 << 14) - 1;
        }
        return arr;
    }

}
