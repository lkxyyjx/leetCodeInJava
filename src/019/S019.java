import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class S019 {
    public static void main(String[] args) {
        S019 solution = new S019();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = solution.removeNthFromEnd(head, 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ln = head;
        Map<Integer, ListNode> ListIndex = new HashMap<>();
        int index = 1;
        while(ln != null) {
            ListIndex.put(index, ln);
            index ++;
            ln = ln.next;
        }
        if (index - 1 == n) {
            return head.next;
        } else {
            ListIndex.get(index - n - 1).next = ListIndex.get(index - n + 1);
            return head;
        }
    }
}

