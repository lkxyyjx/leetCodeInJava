import java.util.List;
import java.util.Stack;

public class S025 {

    public static void main(String[] args) {
        S025 solution = new S025();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(6);
        ListNode res = solution.reverseKGroup(head, 3);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) return head;

        Stack<ListNode> lnStack = new Stack<>();
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pResForStackAdd = head;
        ListNode formerNode = res;
        ListNode nextNode;

        boolean breakLoop = false;

        while (!breakLoop) {
            for (int i = 0 ; i < k ; i ++) {
                if (pResForStackAdd != null) {
                    lnStack.add(pResForStackAdd);
                    pResForStackAdd = pResForStackAdd.next;
                } else {
                    breakLoop = true;
                    break;
                }
            }

            if (!breakLoop) {
                formerNode.next = lnStack.pop();
                formerNode = formerNode.next;
                nextNode = formerNode.next;
                while (!lnStack.isEmpty()) {
                    formerNode.next = lnStack.pop();
                    formerNode = formerNode.next;
                }
                formerNode.next = nextNode;
            }
        }
        return res.next;
    }
}
