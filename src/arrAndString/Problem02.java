package arrAndString;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/7/31 18:55
 */
public class Problem02 {

    public static void main(String[] args) {
        Problem02 problem02 = new Problem02();
        System.out.println(problem02.gcdOfStrings("AA", "A"));
    }

    public String gcdOfStrings(String str1, String str2) {
        //最长公共子串
        int length1 = str1.length();
        int length2 = str2.length();
        boolean b;
        String maxSubStr = "";
        if (length1 < length2){
            b = str2.startsWith(str1);
            maxSubStr = str1;
        }else if (length2 < length1){
            b = str1.startsWith(str2);
            maxSubStr = str2;
        }else {
            return str1.equals(str2)?str1:"";
        }
        if (!b) return "";
        while (maxSubStr.length() > 0){
            if (length1 % maxSubStr.length() == 0 && length2 % maxSubStr.length() == 0
                    && isSubStr(str1,maxSubStr) && isSubStr(str2,maxSubStr)) {
                return maxSubStr;
            }
            else {
                maxSubStr = maxSubStr.substring(0, maxSubStr.length() - 1);
            }
        }
        return "";
    }

    private  boolean isSubStr(String originalStr, String sub){
        int n = originalStr.length() / sub.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append(sub);
        }
        return res.toString().equals(originalStr) ;
    }
}
