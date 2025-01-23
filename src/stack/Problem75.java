package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2025/1/23 18:46
 */
public class Problem75 {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
//        [28],[14],[28],[35],[46],[53],[66],[80],[87],[88]
        int [] prices = {28,14,28,35,46,53,66,80,87,88};
        for (int price : prices) {
            int i = stockSpanner.next(price);
            System.out.println(i);
        }
    }

   static class StockSpanner {

        List<Integer> list;
        Stack<Integer> stack;
        List<Integer> resList;
        public StockSpanner() {
            list = new ArrayList<>();
            resList = new ArrayList<>();
            stack  = new Stack<>();
        }

        public int next(int price) {
            int res = 1;
            //维护最小栈
            while (!stack.isEmpty() && price >= list.get(stack.peek())){
                Integer pop = stack.pop();
                res = resList.size() - pop + resList.get(pop);
            }
            stack.push(resList.size());
            list.add(price);
            resList.add(res);
            return res;
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
}
