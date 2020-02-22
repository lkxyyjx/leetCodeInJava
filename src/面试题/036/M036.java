public class M036 {
    Node listHead;

    public Node treeToDoublyList(Node root) {
        Node lastNode = inOrderChange(root);
        if (lastNode == null) return null;
        listHead.left = lastNode;
        lastNode.right = listHead;
        return listHead;
    }

    private Node inOrderChange(Node root) {
        if (root == null) return null;
        if (listHead == null && root.left == null) {
            listHead = root;
        }
        if (root.left == null && root.right == null) {
            root.right = root;
            return root;
        }
        Node leftTail = root;
        Node rightHead = root;
        Node leftHead = root;
        Node rightTail = root;
        if (root.left != null) {
            leftTail = inOrderChange(root.left);
            root.left = leftTail;
            leftHead = leftTail.right;
            leftTail.right = root;
        }
        if (root.right != null) {
            rightTail = inOrderChange(root.right);
            rightHead = rightTail.right;
            root.right = rightHead;
            rightHead.left = root;
        }
        
        /* 此处使用当前链表尾元素右指针指向当前链表头，并返回当前排序链表尾元素 */
        rightTail.right = leftHead;
        return rightTail;
    }
}
