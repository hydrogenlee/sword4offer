package sword4offer.chapter3;

public class 判断单链表是否存在环 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println("1->2->3->4->null");
        System.out.println(existCycle(head));

        ListNode cycleHead = new ListNode(1);
        ListNode cycleNode1 = new ListNode(2);
        ListNode cycleNode2 = new ListNode(3);
        ListNode cycleNode3 = new ListNode(4);
        cycleHead.next = cycleNode1;
        cycleNode1.next = cycleNode2;
        cycleNode2.next = cycleNode3;
        cycleNode3.next = cycleNode1;
        System.out.println("1->2->3->4+");
        System.out.println("   ^      |");
        System.out.println("   +------+");
        System.out.println(existCycle(cycleHead));
    }

    private static boolean existCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        // 快慢指针
        ListNode quickPointer = head;
        ListNode slowPointer = head;

        while (quickPointer != null) {
            quickPointer = quickPointer.next;
            if (quickPointer == slowPointer) {
                return true;
            }
            if (quickPointer == null) {
                break;
            } else {
                quickPointer = quickPointer.next;
            }
            if (quickPointer == slowPointer) {
                return true;
            }
            slowPointer = slowPointer.next;
            if (quickPointer == slowPointer) {
                return true;
            }
        }


        return false;
    }

    private static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
}
