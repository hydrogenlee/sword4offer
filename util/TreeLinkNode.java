package sword4offer.util;

/**
 * 带有指向父节点指针的二叉树节点
 */
public class TreeLinkNode {
    public int val;                            // 节点值
    public TreeLinkNode left = null;           // 左孩子
    public TreeLinkNode right = null;          // 右孩子
    public TreeLinkNode next = null;           // 父节点

    public TreeLinkNode(int val) {
        this.val = val;
    }
}
