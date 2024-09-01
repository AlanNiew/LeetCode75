package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/28 21:54
 */
public class Problem28 {
    /**
     * 649. Dota2 参议院
     * @param senate
     * @return
     */
    public String predictPartyVictory(String senate) {
        return game(senate);
    }

    /**
     * 游戏思路，前面的参议员禁止后面的参议员行使权力
     * 后面的参议员，禁止前面的参议员。
     * 以此轮转
     * @param senate
     * @return
     */
    public String game(String senate){
        char[] chars = senate.toCharArray();
        int r = 0;
        int d = 0;
        StringBuilder res = new StringBuilder();
        Queue<Character> queueR = new LinkedList<>();
        Queue<Character> queueD = new LinkedList<>();
        //初始化队列
        for (char c : chars) {
            if (c == 'R') {
                if (d == 0){
                    queueR.offer(c);
                    r++;
                    res.append(c);
                }else {
                    d--;
                }
            } else {
                if (r == 0){
                    queueD.offer(c);
                    d++;
                    res.append(c);
                }else {
                    r--;
                }
            }
        }
        popBeforeEnum(r, res, queueD);
        popBeforeEnum(d, res, queueR);
        //知道现在有多少R和D
        if (queueD.isEmpty() && !queueR.isEmpty())return "Radiant";
        if (queueR.isEmpty() && !queueD.isEmpty())return "Dire";
        return game(res.toString());
    }

    private void popBeforeEnum(int n, StringBuilder res, Queue<Character> queueR) {
        while (n > 0 && !queueR.isEmpty()){
            Character poll = queueR.poll();
            //移除前面的参议员
            int index = res.indexOf(String.valueOf(poll));
            res.delete(index,index+1);
            n--;
        }
    }
}
