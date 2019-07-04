public class S105 {
    public static void main(String[] args) {
        S105 solution = new S105();
        TreeNode root = solution.buildTree(new int[] {3,2,1,4}, new int[] {1, 2,3,4});
        TreeNode.preOrderWalk(root);
    }

    int[] preorder;
    int[] inorder;
    TreeNode root;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int treeNodeNum = preorder.length;
        if (treeNodeNum < 1) {
            return null;
        }
        this.preorder = preorder;
        this.inorder = inorder;
        this.root = new TreeNode(preorder[0]);
        dfs(0, preorder.length - 1, 0, inorder.length - 1, this.root);
        return this.root;
    }

    public void dfs(int preStart, int preEnd, int inStart, int inEnd, TreeNode root) {
        if (preStart < preEnd && inStart < inEnd && root != null) {
            int inOrderRootIndex = -1;
            int leftNodeNum = -1;
            for (int i = inStart; i < inEnd + 1; i++) {
                if (this.inorder[i] == root.val) {
                    inOrderRootIndex = i;
                    leftNodeNum = inOrderRootIndex - inStart;
                    break;
                }
            }
            TreeNode leftChild;
            TreeNode rightChild;
            if (((preStart + 1) >= preorder.length) || (leftNodeNum == 0)) {
                leftChild = null;
            } else {
                leftChild = new TreeNode(this.preorder[preStart + 1]);
            }
            root.left = leftChild;
            dfs(preStart + 1, preStart + leftNodeNum, inStart, inOrderRootIndex - 1, leftChild);
            if ((preStart + 1 + leftNodeNum >= preorder.length) || (inEnd - inStart - leftNodeNum == 0)) {
                rightChild = null;
            } else {
                rightChild = new TreeNode(this.preorder[preStart + 1 + leftNodeNum]);
            }
            root.right = rightChild;
            dfs(preStart + 1 + leftNodeNum, preEnd, inOrderRootIndex + 1, inEnd, rightChild);
        }
    }
}
