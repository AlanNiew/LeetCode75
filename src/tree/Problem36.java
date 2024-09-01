package tree;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/31 17:56
 */
public class Problem36 {

    public int pathSum(TreeNode root, int targetSum) {
        dfs(root,root.val,targetSum);
        return count;
    }
    int count = 0;
    public void dfs(TreeNode root,int sum,int target){
        if (root==null) return;
        int val = root.val;
        sum += val;
        if (sum == target){
            count++;
        }
        if (sum>=target){
            sum = val;
        }
        dfs(root.left,sum,target);
        dfs(root.right,sum,target);
    }
}
