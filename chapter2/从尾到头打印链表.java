package sword4offer.chapter2;

import java.util.ArrayList;
import java.util.List;

public class 从尾到头打印链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        List<Integer> list = printListFromTailToHeadRecursive(head);

        for (int i = 0; i < list.size(); i++) {
            System.out.printf(list.get(i) + " ");
        }
    }

    // 改变了链表的结构
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode == null) {
            return result;
        }

        // 头插法
        ListNode head = new ListNode(-1);
        ListNode temp = listNode;
        while (temp != null) {
            listNode = listNode.next;
            temp.next = head.next;
            head.next = temp;
            temp = listNode;
        }

        head = head.next;
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

    public static ArrayList<Integer> printListFromTailToHeadRecursive(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        ListNode node = listNode;
        ArrayList<Integer> temp = printListFromTailToHeadRecursive(listNode.next);
        temp.add(node.val);

        return temp;
    }


    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

}
