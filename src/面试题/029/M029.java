public class M029 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        if(!isSymmetric(left.left, right.right)) return false;
        if (left.val != right.val) return false;
        if(!isSymmetric(left.right, right.left)) return false;
        return true;
    }
}
