import java.util.HashMap;

public class S124 {
    public static void main(String[] args) {
        S124 solution = new S124();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(solution.maxPathSum(root));
    }

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxSum;
    }

    private int maxPathSumHelper(TreeNode root) {
        if (root == null) return 0;
        int leftMaxContribution = Math.max(maxPathSumHelper(root.left), 0);
        int rightMaxContribution = Math.max(maxPathSumHelper(root.right), 0);

        this.maxSum = Math.max(maxSum, leftMaxContribution + rightMaxContribution + root.val);

        return Math.max(leftMaxContribution, rightMaxContribution) + root.val;
    }
}
