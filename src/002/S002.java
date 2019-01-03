/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class S002 {
    public static void main(String[] args) {
        S002 hw = new S002();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = hw.addTwoNumbers(l1,l2);
        String resStr = "";
        while (res != null) {
            resStr += "->" + res.val;
            res = res.next;
        }
        System.out.println(resStr);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val1;
        int val2;
        int twoSum;
        int addOneFlag = 0;
        int singleSum;
        ListNode res = new ListNode(0);
        ListNode point = res;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null || p2 != null || addOneFlag == 1) {
            val1 = p1 == null ? 0 : p1.val;
            val2 = p2 == null ? 0 : p2.val;
            twoSum = val1 + val2 + addOneFlag;
            addOneFlag = twoSum >= 10 ? 1 : 0;
            singleSum = twoSum >= 10 ? twoSum - 10 : twoSum;
            point.next = new ListNode(singleSum);
            point = point.next;
            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next;
        }
        return res.next;
    }
}