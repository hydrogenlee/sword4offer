package sword4offer.chapter3;

public class 反转链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        head = reverseList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
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

    private static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
}
