package doublePointer;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/6 21:43
 */
public class Problem10 {
    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len-1; i++) {
            if (nums[i]==0){
                int j = i + 1;
                while (j<len-1 && nums[j]==0)j++;
                if (nums[j]==0)return;
                swap(nums,i,j);
            }
        }
    }

    private static void swap(int[] nums,int i,int j){
        nums[i] = nums[i]^nums[j];
        nums[j] = nums[i]^nums[j];
        nums[i] = nums[i]^nums[j];
    }
}
