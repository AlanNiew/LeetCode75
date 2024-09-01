package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/31 17:56
 */
public class Problem36 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.build(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        treeNode.show();
        Problem36 problem36 = new Problem36();
        problem36.pathSum(treeNode,22);
    }

    /**
     * 路径总和 III
     * 给定一个二叉树的根节点 root 和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
     * 节点路径需要从树的根节点开始，到叶子节点结束，路径方向可以且只能向下。
     * 思路：递归，先序遍历，判断当前节点值是否等于targetSum，如果等于，则计数器加一，然后递归遍历左子树和右子树
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        //每个节点走一遍DFS
        if (root == null) return 0;
        map.put(0L,1);
        return prefix(root,0,targetSum);
    }
    int count = 0;
    //前缀和
    Map<Long,Integer> map = new HashMap<>();

    public void dfs(TreeNode root,long sum,int target){
        if (root==null) return;
        int val = root.val;
        sum += val;
        if (sum == target){
            count++;
        }
        dfs(root.left,sum,target);
        dfs(root.right,sum,target);
    }

    public int prefix(TreeNode root,long sum,int target){
        if (root == null) return 0;
        sum += root.val;
        int res = 0;
        long preSum = sum - target;
        //找寻是否有符合的前缀和
        res += map.getOrDefault(preSum,0);
        Integer orDefault = map.getOrDefault(sum, 0);
        map.put(sum, orDefault + 1);
        int left = prefix(root.left,sum,target);
        int right = prefix(root.right,sum,target);
        res = res + left + right;
        //遍历完该节点的所有孩子，将其从中减去
        map.put(sum,orDefault);
        return res;
    }

}
