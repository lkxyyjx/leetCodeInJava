public class S021 {
    public static void main(String[] args) {
        S021 solution = new S021();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        ListNode res = solution.mergeTwoLists(head,head2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l2 == null) {
            return l1;
        } else if (l1 == null) {
            return l2;
        }

        ListNode p1 = l1.val > l2.val ? l1 : l1.next;
        ListNode p2 = l1.val > l2.val ? l2.next : l2;
        ListNode res = new ListNode(l1.val > l2.val ? l2.val : l1.val);
        ListNode pres = res;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                pres.next = p2;
                p2 = p2.next;
            } else {
                pres.next = p1;
                p1 = p1.next;
            }
            pres = pres.next;
        }
        if (p1 == null) {
            pres.next = p2;
        } else if (p2 == null) {
            pres.next = p1;
        }
        return res;
    }
}
