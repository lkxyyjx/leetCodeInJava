import java.util.*;

public class S023_1 {
    public static void main(String[] args) {
        S023_1 solution = new S023_1();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(5);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);
        ListNode res = solution.mergeKLists(new ListNode[]{head, head2, head3});
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int listNum = lists.length;

        if (listNum == 0) {
            return null;
        }
        ListNode res = new ListNode(0);
        ListNode pRes = res;
        //Queue<ListNode> pQueue = new PriorityQueue<>(listNum, (ListNode ln1, ListNode ln2) -> (ln1.val - ln2.val));
        Queue<ListNode> pQueue = new PriorityQueue<>(listNum, Comparator.comparingInt((obj)->obj.val));
        for (ListNode list: lists) {
            if (list != null) {
                pQueue.add(list);
            }
        }
        ListNode tempNode;
        while (!pQueue.isEmpty()) {
            tempNode = pQueue.poll();
            pRes.next = tempNode;
            if (tempNode.next != null) {
                pQueue.add(tempNode.next);
            }
            pRes = pRes.next;
        }
        return res.next;
    }
}
