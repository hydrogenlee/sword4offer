package sword4offer.chapter3;

import sword4offer.util.ListNode;

public class 反转链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        Solution solution = new 反转链表().new Solution();
        head = solution.reverseList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            // 链表为空，或者只有一个节点
            if (head == null || head.next == null) {
                return head;
            }
            // 头插法
            ListNode restHead = head.next;
            ListNode temp = head.next;
            head.next = null;

            while (restHead != null) {
                restHead = restHead.next;
                temp.next = head;
                head = temp;
                temp = restHead;
            }
            return head;
        }
    }

}
