public class S100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null && p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else if (p == null && q == null)
            return true;
        else
            return false;
    }
}
d