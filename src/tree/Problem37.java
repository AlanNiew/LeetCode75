package tree;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/9/1 20:56
 */
public class Problem37 {
    public int longestZigZag(TreeNode root) {
        int left = dfs(root.left, 0, 0);
        int right = dfs(root.right,0,1);
        return Math.max(left,right);
    }

    /*
    1.如果当前节点是左节点，那么只能去右节点(如果走左侧，路径将重新计算)
    2.如果当前节点是右节点，那么只能去左节点（如果走右侧，路径将重新计算）
    3.如果当前节点是叶子节点，那么返回当前路径长度
    4.返回当前路径长度和左右子树路径长度中的较大值
     */
    public int dfs(TreeNode root,int sum,int direct){
        if (root == null) return sum;
        int right = 0,left = 0;
        //0-left,1-right
        if (direct == 0){
            int lr = dfs(root.right, sum + 1, 1);
            int ll = dfs(root.left,0,0);
            right = Math.max(lr, ll);
        }else {
            int rl = dfs(root.left, sum + 1, 0);
            int rr = dfs(root.right,0,1);
            left = Math.max(rl, rr);
        }
        return Math.max(right,left);
    }
}
