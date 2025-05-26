package tree;


/**
 * @Author: Niu
 * @Date: 2025/5/21 14:21
 * @Description:
 */
public class Problem41 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{4,2,7,1,3,null,null,null,null,null,5});
        Problem41 problem41 = new Problem41();
        root.show();
        System.out.println(problem41.searchBST(root, 5));
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val > val) return searchBST(root.left, val);
        return searchBST(root.right, val);
    }
}
