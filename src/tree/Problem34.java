package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/31 17:13
 */
public class Problem34 {

    public static void main(String[] args) {
        TreeNode root1 = TreeNode.build(new Integer[]{3,5,1,6,2,9,8,null,null,7,4});
        TreeNode root2 = TreeNode.build(new Integer[]{3,5,1,6,7,4,2,null,null,null,null,null,null,9,8});
        root1.show();
        root2.show();
        Problem34 problem34 = new Problem34();
        System.out.println(problem34.leafSimilar(root1, root2));
    }

    /**
     * 872.叶子相似的树
     * 按指定顺序遍历，将叶子存储下来
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafList1 = new ArrayList<>();
        List<Integer> leafList2 = new ArrayList<>();
        dfs(root1,leafList1);
        dfs(root2,leafList2);
//        System.out.println("leafList1 = " + leafList1);
//        System.out.println("leafList2 = " + leafList2);
        return leafList1.equals(leafList2);
    }
    public void dfs(TreeNode root, List<Integer> leafList){
        if (root == null) return;
        if (root.left == null && root.right==null){
            leafList.add(root.val);
        }
        dfs(root.left,leafList);
        dfs(root.right,leafList);
    }
}
