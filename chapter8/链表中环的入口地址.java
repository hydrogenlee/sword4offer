package sword4offer.chapter8;

import sword4offer.util.ListNode;

public class 链表中环的入口地址 {
    public static void main(String[] args) {

        Solution solution = new 链表中环的入口地址().new Solution();

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
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;

        System.out.println(solution.entryNodeOfLoop(node1).val);
    }

    class Solution {
        // 思路：
        // 先用快慢指针判断是否有环
        // 如果有环，则计算环中节点的数量n
        // 然后一个指针先走n步，然后两个指针同时移动，当再次相遇时，就是入口节点
        public ListNode entryNodeOfLoop(ListNode pHead) {
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

        private ListNode getMeetingNode(ListNode pHead) {
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
    }

}
