package sword4offer.chapter8;

public class 链表中环的入口地址 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -+
        //                             |
        //           ^                 |
        //           +-----------------+
        ListNode head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;

        System.out.println(entryNodeOfLoop(head).val);
    }

    // 思路：
    // 先用快慢指针判断是否有环
    // 如果有环，则计算环中节点的数量n
    // 然后一个指针先走n步，然后两个指针同时移动，当再次相遇时，就是入口节点
    public static ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode meetingNode = getMeetingNode(pHead);
        if (meetingNode == null) {
            return null;
        }

        // 获取环中节点的数目
        ListNode temp = meetingNode.next;
        int num = 1;
        while (meetingNode != temp) {
            temp = temp.next;
            num++;
        }

        ListNode quickNode = pHead;
        ListNode slowNode = pHead;
        for (int i = 0; i < num; i++) {
            quickNode = quickNode.next;
        }

        while (quickNode != slowNode) {
            quickNode = quickNode.next;
            slowNode = slowNode.next;
        }

        return quickNode;
    }

    private static ListNode getMeetingNode(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        ListNode quickPointer = pHead;
        ListNode slowPointer = pHead;

        while (quickPointer != null) {
            quickPointer = quickPointer.next;
            if (quickPointer == null) {
                break;
            }
            quickPointer = quickPointer.next;
            slowPointer = slowPointer.next;
            if (quickPointer == slowPointer) {
                return quickPointer;
            }
        }
        return null;
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
