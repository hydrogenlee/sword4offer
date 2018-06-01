package sword4offer.chapter3;

public class 在O1时间删除链表节点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head = deleteNode(head, head.next.next.next);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static ListNode deleteNode(ListNode head, ListNode nodeToBeDeleted){
        if (head == null || nodeToBeDeleted == null) {
            return null;
        }

        // 删除头结点
        if (head == nodeToBeDeleted) {
            head = head.next;
        } else if (nodeToBeDeleted.next == null) {
            // 删除最后一个节点，只能从头开始遍历
            ListNode temp = head;
            while (temp.next != nodeToBeDeleted) {
                temp = temp.next;
            }
            temp.next = null;
        } else {
            // 删除中间节点
            nodeToBeDeleted.val = nodeToBeDeleted.next.val;
            nodeToBeDeleted.next = nodeToBeDeleted.next.next;
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
