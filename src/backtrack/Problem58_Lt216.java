package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Niu
 * @date 2026-05-07
 */
public class Problem58_Lt216 {
    public static void main(String[] args) {
        System.out.println(sum(1,1));
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(9,n,k,res,path);
        return res;
    }

    private void dfs(int i,int leftSum,int k, List<List<Integer>> res,List<Integer> path) {
        // 还要选几个
        int d = k - path.size();
        // 等差数列 i + n - 1 /2
        if (leftSum<0 || leftSum > (i*2-d+1)*d/2)  return;
        if(d==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j >=d; j--) {
            path.add(j);
            dfs(j-1,leftSum-j,k,res,path);
            path.remove(path.size()-1);
        }
    }

    // 等差数列求和
    private static int sum(int a1,int an){
        return (3 + 9) * 6 / 2;
    }

}
