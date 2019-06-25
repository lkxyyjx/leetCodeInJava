import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S098 {
    public static void main(String[] args) {
        S098 solution = new S098();
        TreeNode root = new TreeNode(1);
        //root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        System.out.println(solution.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        List<Integer> midWalkRes = new ArrayList<>();
        midWalk(root, midWalkRes);

        System.out.println(midWalkRes.size());
        for (int i = 1; i < midWalkRes.size(); i ++) {
            if (midWalkRes.get(i) <= midWalkRes.get(i - 1)) return false;
        }

        return true;
    }

    public void midWalk(TreeNode root, List<Integer> res) {
        Stack<TreeNode> walkStack = new Stack<>();
        TreeNode p = root;
        while (p != null || !walkStack.empty()) {
            while (p != null) {
                walkStack.push(p);
                p = p.left;
            }

            if (!walkStack.empty()) {
                p = walkStack.pop();
                res.add(p.val);
                p = p.right;
            }
        }
    }
}
