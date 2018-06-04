package sword4offer.chapter4;

import java.util.Hashtable;
import java.util.Map;

public class 复杂链表的复制 {
    public static void main(String[] args) {
        RandomListNode A = new RandomListNode(1);
        RandomListNode B = new RandomListNode(2);
        RandomListNode C = new RandomListNode(3);
        RandomListNode D = new RandomListNode(4);
        RandomListNode E = new RandomListNode(5);
        A.next = B;
        A.random = C;
        B.next = C;
        B.random = E;
        C.next = D;
        D.next = E;
        D.random = B;

        System.out.println("-----------Method1-----------");
        RandomListNode result = clone(A);
        while (result != null) {
            System.out.println(result.label + ": next -> " + (result.next != null ? result.next.label : null) +
                    "; random -> " + (result.random != null ? result.random.label : null));
            result = result.next;
        }

        System.out.println("-----------Method2-----------");
        result = clone2(A);
        while (result != null) {
            System.out.println(result.label + ": next -> " + (result.next != null ? result.next.label : null) +
                    "; random -> " + (result.random != null ? result.random.label : null));
            result = result.next;
        }

        System.out.println("-----------Method3-----------");
        result = clone3(A);
        while (result != null) {
            System.out.println(result.label + ": next -> " + (result.next != null ? result.next.label : null) +
                    "; random -> " + (result.random != null ? result.random.label : null));
            result = result.next;
        }
    }

    // 先复制 next指针，然后再复制random指针
    // T-C: O(N^2)
    // S-C：O(1)
    private static RandomListNode clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // 首先，现复制next指针和label
        RandomListNode result = new RandomListNode(-1);
        RandomListNode curr = result;
        RandomListNode originalHead = pHead;
        while (pHead != null) {
            curr.next = new RandomListNode(pHead.label);
            curr = curr.next;
            pHead = pHead.next;
        }
        // 然后复制random指针
        curr = result;
        while (originalHead != null) {
            if (originalHead.random != null) {
                RandomListNode temp = result;
                while (temp.label != originalHead.random.label) {
                    temp = temp.next;
                }
                curr.random = temp;
            }
            curr = curr.next;
            originalHead = originalHead.next;
        }

        return result;
    }

    // 先复制next指针，然后将旧节点和新节点保存在hash table中 ，
    // 然后通过hash table来复制random指针
    // T-C: O(N)
    // S-C: O(N)
    private static RandomListNode clone2(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> table = new Hashtable<>();
        RandomListNode result = new RandomListNode(-1);
        RandomListNode cur = result;
        // 复制next指针
        while (pHead != null) {
            cur.next = new RandomListNode(pHead.label);
            table.put(pHead, cur.next);
            table.put(cur.next, pHead);
            pHead = pHead.next;
            cur = cur.next;
        }
        // 复制random指针
        cur = result.next;          // 至少有一个节点
        while (cur != null) {
            RandomListNode temp = table.get(cur).random;
            cur.random = (temp == null ? null : table.get(temp));
            cur = cur.next;
        }
        return result.next;
    }

    // 先复制next指针，然后将旧节点和新节点保存在hash table中 ，
    // 然后通过hash table来复制random指针
    // T-C: O(N)
    // S-C: O(1)
    private static RandomListNode clone3(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode originalHead = pHead;
        // 按照 A->A'->B->B'->C->C' 的顺序排起来
        while (pHead != null) {
            RandomListNode temp = new RandomListNode(pHead.label);
            temp.next = pHead.next;
            pHead.next = temp;
            pHead = pHead.next.next;
        }

        // 复制random指针
        pHead = originalHead;
        while (pHead != null) {
            RandomListNode temp = pHead.random;
            pHead.next.random = (temp == null ? null : temp.next);
            pHead = pHead.next.next;
        }

        // 重新设置next指针
        pHead = originalHead;
        RandomListNode result = originalHead.next;
        RandomListNode temp = result;
        while (pHead != null) {
            pHead.next = temp.next;
            pHead = pHead.next;
            if (pHead != null) {
                temp.next = pHead.next;
                temp = temp.next;
            }
        }
        return result;
    }

    private static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }

    }


}
