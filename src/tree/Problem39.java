package tree;

import java.util.*;

/**
 * @Author: Niu
 * @Date: 2025/5/21 13:34
 * @Description:
 */
public class Problem39 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{1,2,3,4,null,null,null,5});
        Problem39 problem39 = new Problem39();
        problem39.levelOrder(root);
//        List<Integer> list = problem39.rightSideView(root);
//        System.out.println(list);
    }
    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        dfs(root,0,map);
        return map.values().stream().toList();
    }
    public void dfs(TreeNode root, int depth, Map<Integer,Integer> map){
        if (root == null) return;
        map.put(depth,root.val);
        dfs(root.left,depth+1,map);
        dfs(root.right,depth+1,map);
    }

    //层序遍历
    public void levelOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int curVal = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                curVal = node.val;
//                res.add(node.val); // 正常层序遍历
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(curVal); // 只记录每层的最右边的节点
        }
    }
}
