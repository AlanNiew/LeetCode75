package oneQuestionPerDay;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/19 21:07
 */
public class LC_551 {
    public boolean checkRecord(String s) {
        int absent = 0;
        int late = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                absent++;
                if (absent>=2){
                    return false;
                }
            }
            if (c=='L'){
                late++;
                if (late>=3){
                    return false;
                }
            }else {
                late = 0;
            }
        }
        return true;
    }


}
