package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/9/4 21:18
 */
public class Problem38 {

    /**
     * 236. 二叉树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p);
        dfs(root,q);
        pRootList.stream().map(item->item.val).forEach(a-> System.out.print(" "+a));
        System.out.println();
        qRootList.stream().map(item->item.val).forEach(a-> System.out.print(" "+a));
        if (pRootList.contains(q)){
            return q;
        }
        if (qRootList.contains(p)){
            return p;
        }
        return root;
    }
    List<TreeNode> pRootList = new ArrayList<>();
    List<TreeNode> qRootList = new ArrayList<>();
    private void dfs(TreeNode root,TreeNode p){
        if (root == null)return;
        if (root.left != null && root.right != null){
            pRootList.add(root);
            if (p.val == root.val) return;
        }
        dfs(root.left,p);
        dfs(root.right,p);
    }
}
