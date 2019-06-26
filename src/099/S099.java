import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S099 {
    public static void main(String[] args) {
        S099 solution = new S099();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        solution.recoverTree(root);
    }

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        List<Integer> midWalkRes = new ArrayList<>();
        List<Integer> invalidKey = new ArrayList<>();
        int[] toExchangeValue = new int[2];
        midWalk(root, midWalkRes);
        for (int i = 1; i < midWalkRes.size(); i++) {
            if (midWalkRes.get(i) < midWalkRes.get(i - 1)) {
                invalidKey.add(i);
            }
        }
        if (invalidKey.size() == 1) {
            toExchangeValue[0] = midWalkRes.get(invalidKey.get(0) - 1);
            toExchangeValue[1] = midWalkRes.get(invalidKey.get(0));
        } else if (invalidKey.size() == 2) {
            toExchangeValue[0] = midWalkRes.get(invalidKey.get(0) - 1);
            toExchangeValue[1] = midWalkRes.get(invalidKey.get(1));
        } else {
            return;
        }

        TreeNode[] toExchangeNode = new TreeNode[2];
        Stack<TreeNode> walkStack = new Stack<>();
        TreeNode p = root;
        int pToExchangeNode = 0;
        while(p != null || !walkStack.empty()) {
            if (p != null) {
                walkStack.push(p);
                p = p.left;
            } else {
                p = walkStack.pop();
                if (p.val == toExchangeValue[0] || p.val == toExchangeValue[1]) {
                    toExchangeNode[pToExchangeNode ++] = p;
                }
                p = p.right;
            }
        }

        int temp;
        temp = toExchangeNode[0].val;
        toExchangeNode[0].val = toExchangeNode[1].val;
        toExchangeNode[1].val = temp;
    }

    public void midWalk(TreeNode root, List<Integer> res) {
        Stack<TreeNode> walkStack = new Stack<>();
        TreeNode p = root;
        while (p != null || !walkStack.empty()) {
            while (p != null) {
                walkStack.push(p);
                p = p.left;
            }

            p = walkStack.pop();
            res.add(p.val);
            p = p.right;
        }
    }
}
