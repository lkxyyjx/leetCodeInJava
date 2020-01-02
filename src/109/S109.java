import java.util.ArrayList;
import java.util.List;

public class S109 {
    List<Integer> sortedList = new ArrayList<>();

    public static void main (String[] args) {
        S109 solution = new S109();
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(9);
        head.next.next.next.next = new ListNode(5);
        TreeNode.preOrderWalk(solution.sortedListToBST(head));
    }

    public TreeNode sortedListToBST(ListNode head) {
        listToArrayList(head);
        TreeNode pRoot = new TreeNode(0);
        buildBstHelper(0, this.sortedList.size() - 1, pRoot, 0);
        return pRoot.left;
    }

    private void listToArrayList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            this.sortedList.add(p.val);
            p = p.next;
        }
    }

    private void buildBstHelper(int firstIndex, int lastIndex, TreeNode root, int leftOrRight) {
        if (firstIndex > lastIndex) return;
        int newRootIndex = (lastIndex - firstIndex)/2 + firstIndex;
        if (newRootIndex >= this.sortedList.size()) return;
        TreeNode nextRoot;
        if (leftOrRight == 0) {
            root.left = new TreeNode(this.sortedList.get(newRootIndex));
            nextRoot = root.left;
        } else {
            root.right = new TreeNode(this.sortedList.get(newRootIndex));
            nextRoot = root.right;
        }
        buildBstHelper(firstIndex, newRootIndex - 1, nextRoot, 0);
        buildBstHelper(newRootIndex + 1, lastIndex, nextRoot, 1);
    }
}
