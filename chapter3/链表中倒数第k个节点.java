package sword4offer.chapter3;

import sword4offer.util.ListNode;

public class 链表中倒数第k个节点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        Solution solution = new 链表中倒数第k个节点().new Solution();
        head = solution.findKthToTail(head, 5);
        System.out.println(head.val);
    }

    class Solution {
        public ListNode findKthToTail(ListNode head,int k) {
            if (head == null) {
                return null;
            }
            if (k <= 0) {
                return null;
                // throw new IllegalArgumentException("参数输入错误：k需要大于0");
            }

            // 快慢指针
            ListNode quickPointer = head;
            ListNode slowPointer = head;

            // 先走k-1步
            for (int i = 1; i <= k - 1; i++) {
                if (quickPointer.next == null) {
                    return null;
                    // throw new IllegalArgumentException("参数输入错误：k的值大于链表的长度");
                }
                quickPointer = quickPointer.next;
            }

            while (quickPointer.next != null) {
                quickPointer = quickPointer.next;
                slowPointer = slowPointer.next;
            }

            return slowPointer;
        }
    }
}
