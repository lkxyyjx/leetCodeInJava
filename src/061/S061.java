import java.util.List;

public class S061 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode pPre = head;
        ListNode pAfter = null;
        ListNode resHead;
        int pPreCount = 0;
        int kCopy = k;
        while (pPre != null) {
            pPreCount ++;
            if (pPreCount == kCopy + 1) {
                pAfter = head;
            }
            if (pPre.next == null) {
                if (pPreCount <= kCopy) {
                    kCopy = kCopy % pPreCount;
                    pPreCount = 0;
                    pPre = head;
                    continue;
                }
                break;
            }
            pAfter = pAfter == null ? null : pAfter.next;
            pPre = pPre.next;
        }
        if (pAfter.next == null) return head;
        resHead = pAfter.next;
        pAfter.next = null;
        pPre.next = head;
        return resHead;
    }
}
