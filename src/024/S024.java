import java.util.List;

public class S024 {
    public static void main(String[] args) {
        S024 solution = new S024();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(6);
        ListNode res = solution.swapPairs(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode formerNode = res;
        ListNode pNode = head;
        ListNode pNodeNext = pNode == null ? null : pNode.next;
        while (pNode != null && pNodeNext != null) {
            pNode.next = pNodeNext.next;
            pNodeNext.next = pNode;
            formerNode.next = pNodeNext;
            formerNode = pNode;
            pNode = pNode.next;
            pNodeNext = pNode == null ? null : pNode.next;
        }
        if (pNode != null) {
            formerNode.next = pNode;
        }

        return res.next;
    }

}
