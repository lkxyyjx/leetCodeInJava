import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class S092 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode headPre = new ListNode(0);
        headPre.next = head;
        ListNode mPre = headPre;
        ListNode nNext;
        ListNode cur = head;
        int nodesCount = 1;
        Deque<ListNode> reverseStack = new LinkedList<>();
        while (cur != null) {
            if (nodesCount < m) {
                cur = cur.next;
                mPre = mPre.next;
                nodesCount ++;
            } else if (nodesCount < n){
                reverseStack.push(cur);
                cur = cur.next;
                nodesCount ++;
            } else if (nodesCount >= n) {
                reverseStack.push(cur);
                break;
            }
        }
        nNext = cur.next;
        while (!reverseStack.isEmpty()) {
            mPre.next = reverseStack.poll();
            mPre = mPre.next;
        }
        mPre.next = nNext;
        return headPre.next;
    }
}
