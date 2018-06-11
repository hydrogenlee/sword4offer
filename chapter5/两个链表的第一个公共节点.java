package sword4offer.chapter5;

import sword4offer.util.ListNode;

public class 两个链表的第一个公共节点 {
    public static void main(String[] args) {

        Solution solution = new 两个链表的第一个公共节点().new Solution();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        // 1 -> 2 -> 3 ->
        //                6 -> 7
        //      4 -> 5 ->
        ListNode pHead1 = node1;
        pHead1.next = node2;
        pHead1.next.next = node3;
        pHead1.next.next.next = node6;
        pHead1.next.next.next.next = node7;

        ListNode pHead2 = node4;
        pHead2.next = node5;
        pHead2.next.next = node6;
        pHead2.next.next.next = node7;

        ListNode result = solution.findFirstCommonNode(pHead1, pHead2);
        System.out.println(result == null ? "" : result.val);
        System.out.println("-------------------------------------");

        // head1 -> 1 -> 2 -> 3 ->
        // head2 ->                4 -> 5
        pHead1 = node1;
        pHead1.next = node2;
        pHead1.next.next = node3;
        pHead1.next.next.next = node4;
        pHead1.next.next.next.next = node5;

        pHead2 = node4;
        pHead2.next = node5;

        result = solution.findFirstCommonNode(pHead1, pHead2);
        System.out.println(result == null ? "" : result.val);
    }

    class Solution {
        public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            if (pHead1 == null || pHead2 == null) {
                return null;
            }

            ListNode pointer1 = pHead1;
            ListNode pointer2 = pHead2;
            while (pointer1 != pointer2) {
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
                if (pointer1 == null && pointer2 == null) {
                    break;
                }
                if (pointer1 == null) {
                    pointer1 = pHead2;
                }
                if (pointer2 == null) {
                    pointer2 = pHead1;
                }
            }
            return pointer1;
        }
    }
}
