package tree;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/31 16:52
 */
public class Problem33 {
    public static void main(String[] args) {
        //满二叉
        TreeNode root = TreeNode.build(new Integer[]{3,9,20,3,4,15,7,11});
        root.show();
    }

    /**
     * 104. 二叉树的最大深度
     * 递归遍历二叉树深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
