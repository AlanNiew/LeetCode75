package tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author: Niu
 * @Date: 2025/5/21 14:06
 * @Description:
 */
public class Problem40 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{-100,-200,-300,-20,-5,-10,null});
        Problem40 problem40 = new Problem40();
        root.show();
//        System.out.println(problem40.maxLevelSum(root));
    }

    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        int max = root.val,level = 1,ans = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int sum = 0;
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (sum > max){
                max = sum;
                ans = level;
            }
            level++;
        }
        return ans;
    }

}
