public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    public static void preOrderWalk(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrderWalk(root.left);
            preOrderWalk(root.right);
        } else {
            System.out.println("null");
        }
    }
}
