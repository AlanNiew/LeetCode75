package oneQuestionPerDay;

import java.util.Arrays;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2025/1/5 10:46
 */
public class Lt_2241 {

    /*
    一个 ATM 机器，存有 5 种面值的钞票：20 ，50 ，100 ，200 和 500 美元。初始时，ATM 机是空的。用户可以用它存或者取任意数目的钱。

取款时，机器会优先取 较大 数额的钱。

比方说，你想取 $300 ，并且机器里有 2 张 $50 的钞票，1 张 $100 的钞票和1 张 $200 的钞票，那么机器会取出 $100 和 $200 的钞票。
但是，如果你想取 $600 ，机器里有 3 张 $200 的钞票和1 张 $500 的钞票，那么取款请求会被拒绝，因为机器会先取出 $500 的钞票，然后无法取出剩余的 $100 。注意，因为有 $500 钞票的存在，机器 不能 取 $200 的钞票。
     */

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.deposit(new int[]{0,0,1,2,1});
        int[] withdraw = atm.withdraw(600);
        System.out.println(Arrays.toString(withdraw));
    }

    static class ATM {
        //面值
        int[] parValueArr = {20,50,100,200,500};
        //ATM 中面值数量
        int[] countArr;
        int count = 5;
        public ATM() {
            countArr = new int[count];
        }

        /**
         * 存钱
         * @param banknotesCount
         */
        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < count; i++) {
                countArr[i] += banknotesCount[i];
            }
        }

        /**
         * 取钱
         * @param amount
         * @return
         */
        public int[] withdraw(int amount) {
            //取钱从大往小的取
            int index = count - 1;
            int [] res = new int[count];
            int [] tmpArr = countArr.clone();
            //取不了就还原回去
            while (index >= 0) {
                int par = parValueArr[index];//当前面值
                //看最多能取多少
                int parCount = amount / par;
                //当前剩余数量
                int curCount = countArr[index];
                //取钱数量
                int min = Math.min(parCount, curCount);
                //计算
                countArr[index] -= min;
                int total = par * min;
                amount -= total;
                res[index] += min;
                if (amount == 0){
                    return res;
                }
                index--;
            }
            if (amount == 0){
                return res;
            }else{
                countArr = tmpArr;
                return new int[]{-1};
            }
        }
    }

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
}
