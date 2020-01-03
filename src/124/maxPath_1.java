/**
 *
 * 若124题中路径计算方法为父子节点距离为1
 *
 */
public class maxPath_1 {
    public static void main(String[] args) {
        maxPath_1 solution = new maxPath_1();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(solution.maxPathSum(root));
    }

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        height(root);
        return maxSum - 2;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left) + 1;
        int rightHeight = height(root.right) + 1;

        this.maxSum = Math.max(maxSum, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight);
    }
}
