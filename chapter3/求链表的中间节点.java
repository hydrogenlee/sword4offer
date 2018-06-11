package sword4offer.chapter3;

import sword4offer.util.ListNode;

public class 求链表的中间节点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution solution = new 求链表的中间节点().new Solution();
        head = solution.getCenterNode(head);
        System.out.println(head.val);
    }

    class Solution {
        public ListNode getCenterNode(ListNode head) {
            if (head == null) {
                return null;
            }
            // 使用快慢指针
            ListNode quickPointer = head;      // 一次走两步
            ListNode slowPointer = head;       // 一次走一步

            while (quickPointer != null) {
                quickPointer = quickPointer.next;
                if (quickPointer == null) {
                    break;
                }
                // 如果是偶数，可能是前一个，也可能是后一个
                quickPointer = quickPointer.next;
                slowPointer = slowPointer.next;
            }

            return slowPointer;
        }
    }
}

