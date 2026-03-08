package tree;

/**
 * @Author: Niu
 * @Date: 2025/5/21 14:39
 * @Description:
 */
public class Problem42 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{5,3,8,null,4,7,9,1,null,6});
        root.show();
        new Problem42().deleteNode(root, 5).show();
    }
    // 二叉搜索树的性质：左子树小于根节点，右子树大于根节点
    /**
     * 删除二叉搜索树中的一个节点
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                TreeNode minNode = getMinNode(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.val);
            }
        }
        return root;
    }

    /**
     * 获取二叉搜索树的最小节点， 二叉搜索树的最小节点在左子树的最左节点
     * @param root 二叉搜索树的根节点
     * @return 二叉搜索树的最小节点
     */
    private TreeNode getMinNode(TreeNode root) {
        while (root.left != null) root = root.left;
        return root;
    }
}
