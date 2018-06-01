package sword4offer.chapter2;

public class 重建二叉树 {
    public static void main(String[] args) {
        TreeNode root = reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8},
                new int[]{4, 7, 2, 1, 5, 3, 8, 6});
        printTree(root);
    }

    // 中序遍历
    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            printTree(root.left);
        }
        System.out.println(root.val);
        if (root.right != null) {
            printTree(root.right);
        }
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null) {
            if (pre == null && in == null) {
                return null;
            }
            throw new IllegalArgumentException("输入参数不正确");
        }

        if (pre.length != in.length) {
            throw new IllegalArgumentException("前序遍历数组和中序遍历数组长度不同");
        }

        return doRecursive(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public static TreeNode doRecursive(int[] pre, int preStart, int preEnd,
                                       int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int index = inStart;
        for (; index <= inEnd; index++) {
            if (pre[preStart] == in[index]) {
                break;
            }
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int preMid = preStart + index - inStart;
        root.left = doRecursive(pre, preStart + 1, preMid, in, inStart, index - 1);
        root.right = doRecursive(pre, preMid + 1, preEnd, in, index + 1, inEnd);

        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
