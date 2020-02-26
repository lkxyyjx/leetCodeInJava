public class S236 {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return res;
    }

    private boolean find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean leftRes;
        boolean rightRes;
        boolean curRes = false;
        if (root == p || root == q) curRes = true;
        leftRes = find(root.left, p, q);
        rightRes = find(root.right, p, q);
        if (res == null && ((rightRes && leftRes) || (rightRes && curRes) || (leftRes && curRes))) res = root;
        return leftRes || rightRes || curRes;
    }
}
