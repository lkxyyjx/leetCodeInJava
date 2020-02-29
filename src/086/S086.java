public class S086 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode headPre = new ListNode(0);
        headPre.next = head;
        ListNode cur = head;
        ListNode curPre = headPre;
        ListNode pre = headPre;
        while (cur != null) {
            if (cur.val < x) {
                //delete cur from list
                curPre.next = cur.next;
                //insert after pre
                cur.next = pre.next;
                pre.next = cur;
                //iterate
                if (pre == curPre) {
                    curPre = curPre.next;
                    cur = cur.next;
                } else {
                    cur = curPre.next;
                }
                pre = pre.next;
            } else {
                curPre = curPre.next;
                cur = cur.next;
            }
        }
        return headPre.next;
    }
}
