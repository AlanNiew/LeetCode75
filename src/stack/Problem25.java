package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/25 16:27
 */
public class Problem25 {
    public static void main(String[] args) {
        Problem25 problem25 = new Problem25();
        int [] arr = new int[]{1,-2,-2,-2};
        System.out.println(Arrays.toString(problem25.asteroidCollision(arr)));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int before : asteroids) {
            if (stack.isEmpty()){
                stack.push(before);
            }else {
                while (true){
                    Integer last = stack.peek();
                    if (isCollision(last,before)){
                        int abs = Math.abs(before);
                        if (last > abs){
                            break;
                        }else if (last == abs){
                            stack.pop();
                            break;
                        }else {
                            stack.pop();
                            if (stack.isEmpty()){
                                stack.push(before);
                                break;
                            }
                        }
                    }else {
                        stack.push(before);
                        break;
                    }
                }
            }
        }
        int[] ansArr = new int[stack.size()];
        int index = stack.size();
        while (!stack.isEmpty()){
            ansArr[--index] = stack.pop();
        }
        return ansArr;
    }

    //是否碰撞
    private boolean isCollision(int a,int b){
        return (a > 0 && b < 0);
    }

}
