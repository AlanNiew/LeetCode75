package week02;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/5 18:54
 */
public class Problem08 {

    public static void main(String[] args) {
        Problem08 problem08 = new Problem08();
        int[] ints = {1,5,0,4,1,3};
        boolean b = problem08.increasingTriplet(ints);
        System.out.println(b);
    }

    /**
     * 给你一个整数数组nums ，判断这个数组中是否存在长度为 3 的递增子序列。
     * @param nums 整数数组
     * @return 是否存在长度为 3 的递增子序列
     */
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len<3)return false;
        int i =0,j=0,k=0;
        while (i<len-2){
            j = i+1;
            while (j<len-1 && nums[i]==nums[j]) {
                j++;
            }
            if (nums[i] > nums[j]) {
                i = j;
                continue;
            }
            k = j+1;
            while (nums[j]==nums[k]) k++;
            while (k<len-1) {
                if (nums[j]>nums[k]) {
                    if (nums[i]<nums[k]) {
                        j = k;
                    }else {
                        i = k;
                        continue;
                    }
                    k++;
                }
            }
            if (nums[i]<nums[j]&&nums[j]<nums[k])return true;
            i++;
        }
        return false;
    }
}
