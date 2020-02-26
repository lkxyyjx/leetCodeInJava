public class M054 {
    int index = -1;
    int k;
    int res;
    public int kthLargest(TreeNode root, int k) {
        if (root == null)return 0;
        this.k = k;
        this.inOrderWalk(root);
        return res;
    }

    private void inOrderWalk(TreeNode root) {
        if (index >= k) {
            return;
        }
        if (root == null) {
            index = index == -1 ? 0 : index;
            return;
        }
        inOrderWalk(root.right);
        index ++;
        if (index == k) res = root.val;
        inOrderWalk(root.left);
    }
}
