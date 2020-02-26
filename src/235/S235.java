public class S235 {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return res;
        if (root.val > p.val && root.val > q.val) {
            lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            lowestCommonAncestor(root.right, p, q);
        }
        res = root;
        return res;
    }
}
