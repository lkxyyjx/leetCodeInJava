public class S083 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)return head;
        ListNode cur;
        ListNode start;
        start = head;
        cur = head;
        while (cur.next != null) {
            cur = cur.next;
            if (cur.val == start.val) {
                continue;
            } else {
                start.next = cur;
                start = cur;
            }
        }
        if (start.val == cur.val) start.next = null;
        return head;
    }
}
