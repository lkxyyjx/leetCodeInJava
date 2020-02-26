import java.util.LinkedList;
import java.util.List;

public class S863 {
    List<Integer> res = new LinkedList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (K == 0) {
            res.add(target.val);
            return res;
        }
        findKDepthChild(target, K, 0);
        findOtherKDistanceNode(root, target, K);
        return res;
    }

    private int findOtherKDistanceNode(TreeNode root, TreeNode target, int k) {
        if (target == root) return 1;
        if (root == null) return -1;
        int targetDisLeft;
        int targetDisRight;
        int targetDis;
        targetDisLeft = findOtherKDistanceNode(root.left, target, k);
        targetDisRight = findOtherKDistanceNode(root.right, target, k);
        targetDis = Math.max(targetDisLeft, targetDisRight);
        if (targetDis == k) {
            res.add(root.val);
        }
        if (targetDis > 0 && targetDis < k) {
            if (targetDisLeft != -1) findKDepthChild(root.right, k - targetDis, 1);
            if (targetDisRight != -1) findKDepthChild(root.left, k - targetDis, 1);
        }
        return targetDis == -1 ? targetDis : targetDis + 1;
    }

    private void findKDepthChild(TreeNode root, int k, int depth) {
        if (root == null) return;
        if (k == depth) {
            res.add(root.val);
            return;
        }
        findKDepthChild(root.left, k, depth + 1);
        findKDepthChild(root.right, k, depth + 1);
    }
}
