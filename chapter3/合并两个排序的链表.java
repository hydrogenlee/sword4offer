package sword4offer.chapter3;

import sword4offer.util.ListNode;

public class 合并两个排序的链表 {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(5);

        Solution solution = new 合并两个排序的链表().new Solution();
        ListNode result = solution.mergeList(head1, head2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    class Solution {
        public ListNode mergeList (ListNode list1, ListNode list2) {
            if (list1 == null || list2 == null) {
                return list1 == null ? list2 : list1;
            }
            // 两个链表都不为空
            ListNode head = new ListNode(-1);       // 头结点
            ListNode temp = head;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    temp.next = list1;
                    list1 = list1.next;
                } else {
                    temp.next = list2;
                    list2 = list2.next;
                }
                temp = temp.next;
            }
            temp.next = (list1 != null) ? list1 : list2;

            return head.next;
        }
    }
}
