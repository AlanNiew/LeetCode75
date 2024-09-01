package tree;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/31 17:43
 */
public class Problem35 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{3,1,4,3,null,1,5});
        root.show();
        System.out.println(new Problem35().goodNodes(root));
    }
    /**
     * 1448. 统计二叉树中好节点的数目
     * 递归遍历二叉树，记录最大值，如果当前节点值大于最大值，则计数器加一
     * @param root
     * @return
     */
    public int goodNodes(TreeNode root) {
        dfs(root,root.val);
        return count;
    }
    int count = 0;
    public void dfs(TreeNode root,int max){
        if (root==null)return;
        int val = root.val;
        if (val>=max) {
            max = val;
            count++;
        }
        dfs(root.left,max);
        dfs(root.right,max);
    }
}
