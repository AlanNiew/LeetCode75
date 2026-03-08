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
        TreeNode root = TreeNode.build(new Integer[]{1,7,3,7,-8,null,null});
        Problem40 problem40 = new Problem40();
        root.show();
        System.out.println(problem40.maxLevelSum(root));
    }

    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        int max = Integer.MIN_VALUE, level = 1, ans = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            System.out.println("第"+level+"层和为:"+sum);
            if (sum > max){
                max = sum;
                ans = level;
            }
            level++;
        }
        return ans;
    }

}
