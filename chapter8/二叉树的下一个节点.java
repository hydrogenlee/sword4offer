package sword4offer.chapter8;

public class 二叉树的下一个节点 {
    public static void main(String[] args) {
        //         _______1______
        //        /              \
        //     ___2__          ___3__
        //    /      \        /      \
        //   4      _5       6       7
        //         /  \
        //        8   9
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);
        TreeLinkNode node8 = new TreeLinkNode(8);
        TreeLinkNode node9 = new TreeLinkNode(9);

        node1.left = node2; node1.right = node3;
        node2.left = node4; node2.right = node5; node2.next = node1;
        node3.left = node6; node3.right = node7; node3.next = node1;
        node4.next = node2;
        node5.left = node8; node5.right = node9; node5.next = node2;
        node6.next = node3;
        node7.next = node3;
        node8.next = node5;
        node9.next = node5;

        TreeLinkNode result;

        System.out.println((result = getNext(node1)) == null ? "null" : result.val);             // 6
        System.out.println((result = getNext(node2)) == null ? "null" : result.val);             // 8
        System.out.println((result = getNext(node3)) == null ? "null" : result.val);             // 7
        System.out.println((result = getNext(node4)) == null ? "null" : result.val);             // 2
        System.out.println((result = getNext(node5)) == null ? "null" : result.val);             // 9
        System.out.println((result = getNext(node6)) == null ? "null" : result.val);             // 3
        System.out.println((result = getNext(node7)) == null ? "null" : result.val);             // null
        System.out.println((result = getNext(node8)) == null ? "null" : result.val);             // 5
        System.out.println((result = getNext(node9)) == null ? "null" : result.val);             // 1
    }

    public  static TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            throw new IllegalArgumentException("节点不能为null");
        }
        // 如果有右节点，那么下一个节点就是其右子树最左边的孩子
        // 如果其右节点的左孩子为空，那就返回其右节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }

        // 如果右节点为空，往上回溯，直到当前节点是其父节点的左孩子，
        // 如果到达根节点也没有找到（其实是二叉树最右边的那个节点），返回null
        while (pNode.next != null && pNode.next.left != pNode) {
            pNode = pNode.next;
        }
        // 注意：这里也包括当前节点是根节点，并且根节点的右子树为空的情况
        return pNode.next;
    }

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
