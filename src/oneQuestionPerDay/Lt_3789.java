package oneQuestionPerDay;

/**
 * @author Niu
 * @date 2026-01-03
 */
public class Lt_3789 {
    public static void main(String[] args) {
        Lt_3789 lt_3789 = new Lt_3789();
        System.out.println(lt_3789.minimumCost(5, 4, 15, 2, 3));
    }

    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long res = 0;
        // 先看一下both 是否可选,如果两者和大于等于both可选，则优先选择both
        boolean bothFlag = cost1 + cost2 >= costBoth;
        if (bothFlag) {
            int min = Math.min(need1, need2);
            res = (long) min * costBoth;
            need1 -= min;
            need2 -= min;
        }
        res += cost1 < costBoth? (long)need1*cost1 : (long)need1*costBoth;
        res += cost2 < costBoth? (long)need2*cost2 : (long)need2*costBoth;
        return res;
    }
}
