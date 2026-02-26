package oneQuestionPerDay;

/**
 * @author Niu
 * @date 2026-02-25
 */
public class Lt_1022 {
    public static void main(String[] args) {

    }
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    // dfs
    public int dfs(TreeNode root, int pathSum) {
        if (root == null) {
            return 0;
        }
        pathSum = pathSum * 2 + root.val;
        if (root.left == null && root.right == null) {
            return pathSum;
        }
        return dfs(root.left, pathSum) + dfs(root.right, pathSum);
    }
    //  Definition for a binary tree node.
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


