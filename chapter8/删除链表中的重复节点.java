package sword4offer.chapter8;

import sword4offer.util.ListNode;

public class 删除链表中的重复节点 {
    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        Solution solution = new 删除链表中的重复节点().new Solution();

        ListNode result = solution.deleteDuplication(head);
        while (result != null) {
            System.out.printf(result.val + " ");
            result = result.next;
        }
        System.out.println("\n---------------------------------");
        // 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5 -> 5
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = new ListNode(5);
        result = solution.deleteDuplication(head);
        while (result != null) {
            System.out.printf(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }

    class Solution {
        public ListNode deleteDuplication(ListNode pHead) {
            if (pHead == null) {
                return null;
            }

            ListNode cur = pHead;
            ListNode result = new ListNode(-1);
            ListNode prior = result;
            while (cur != null) {
                if (cur.next == null || cur.val != cur.next.val) {
                    prior.next = cur;
                    prior = cur;
                    cur = cur.next;
                } else {
                    ListNode pre = cur;
                    while (cur != null && cur.val == pre.val) {
                        cur = cur.next;
                    }
                }
            }
            // 确保prior最后一个指向null
            prior.next = null;

            return result.next;
        }
    }
}
