import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class S023 {
    public static void main(String[] args) {
        S023 solution = new S023();
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
        ArrayList<Integer> sortArr = new ArrayList<>();
        ListNode p;
        for (int i = 0; i < listNum; i++) {
            p = lists[i];
            while (p != null) {
                if (sortArr.size() == 0) {
                    sortArr.add(p.val);
                    p = p.next;
                    continue;
                }
                for (int j = 0; j < sortArr.size(); j++) {
                    if (sortArr.get(j) >= p.val) {
                        sortArr.add(j, p.val);
                        break;
                    }
                }
                if (p.val > sortArr.get(sortArr.size() - 1)) sortArr.add(p.val);
                p = p.next;
                for (int seq: sortArr
                     ) {
                    System.out.println(seq);
                }
            }
        }
        for (int i = 0; i < sortArr.size(); i++) {
            pRes.next = new ListNode(sortArr.get(i));
            pRes = pRes.next;
        }
        return res.next;
    }
}
