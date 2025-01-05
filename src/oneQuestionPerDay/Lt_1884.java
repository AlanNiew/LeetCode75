package oneQuestionPerDay;

/**
 * Author:Niu
 * Data:2024/10/13 8:47
 */
public class Lt_1884 {

    public static void main(String[] args) {

    }

    public int twoEggDrop(int n) {
        int res = 1;
        while (n > res){
            n -= res;
            res++;
        }
        return res;
    }
}
