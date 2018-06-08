package sword4offer.chapter8;

public class 对称的二叉树 {
    public static void main(String[] args) {
        //         _______8______
        //        /              \
        //     ___6__          ___6__
        //    /      \        /      \
        //   5       7       7        5
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);

        System.out.println(isSymmetrical(root));            // true
        //         _______8______
        //        /              \
        //     ___6__          ___6__
        //    /      \        /      \
        //   5       7       5        7
        root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(5);              // 这句与上面的不同
        root.right.right = new TreeNode(7);             // 这句与上面的不同

        System.out.println(isSymmetrical(root));            // false

        // 刚开始的时候没有考虑这种情况，对于这种情况，需要将空指针也考虑在内即可
        //         _______7______
        //        /              \
        //     __7__           _7
        //   /      \         /
        //  7       7        7
        root = new TreeNode(7);
        root.left = new TreeNode(7);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(7);

        System.out.println(isSymmetrical(root));            // false
    }

    // 如果前序遍历的方法
    public static boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetricalCore(pRoot, pRoot);
    }

    private static boolean isSymmetricalCore(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }

        // 判断两个节点的值是否相等，然后递归判断
        return node1.val == node2.val &&
                isSymmetricalCore(node1.left, node2.right) &&
                isSymmetricalCore(node1.right, node2.left);
    }


    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
