import java.util.ArrayList;
import java.util.List;

public class S094 {
    public static void main(String[] args) {
        S094 solution = new S094();
        TreeNode root = new TreeNode(1);
        //root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        System.out.println(solution.inorderTraversal(root));

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res;
        res = inorderTraversal(root.left);
        res.add(root.val);
        res.addAll(res.size(), inorderTraversal(root.right));
        return res;
    }
}
