package oneQuestionPerDay;

import java.util.Arrays;

/**
 * @author Niu
 * @date 2026-05-11
 */
public class Lt2553 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Lt2553().separateDigits(new int[]{13, 25, 83, 77})));
    }
    public int[] separateDigits(int[] nums) {
        return Arrays.stream(nums).mapToObj(String::valueOf).flatMapToInt(s->s.chars().map(c->c-'0')).toArray();
    }
}
