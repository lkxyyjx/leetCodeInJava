public class S082 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode headPre = new ListNode(0);
        headPre.next = head;
        ListNode pre = headPre;
        ListNode cur = head;
        int num = head.val;
        boolean delete = false;
        while (cur.next != null) {
            cur = cur.next;
            if (cur.val != num) {
                if (delete) {
                    pre.next = cur;
                    delete = false;
                } else {
                    pre = pre.next;
                }
                num = cur.val;
            } else {
                delete = true;
            }
        }
        if (delete) {
            pre.next = null;
        }

        return headPre.next;
    }
}
