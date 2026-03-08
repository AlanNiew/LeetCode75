package tree;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/9/4 21:18
 */
public class Problem38 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        root.show();
        Problem38 problem38 = new Problem38();
        TreeNode p = TreeNode.build(new Integer[]{5});
        TreeNode q = TreeNode.build(new Integer[]{1});
        problem38.lowestCommonAncestor(root,p,q).show();
    }

    /**
     * 236. 二叉树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        // 递归寻找，分别在左子树和右子树中寻找p和q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 如果left为空，说明p和q都不在root的左子树中，返回right
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
