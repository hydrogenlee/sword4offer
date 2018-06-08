package sword4offer.chapter6;

public class 判断树是不是平衡二叉树 {
    public static void main(String[] args) {
        //          _______1______
        //         /              \
        //     ___2__              3_
        //    /      \               \
        //   4      _5                6
        //         /
        //        7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        System.out.println(isBalancedTree(root));
        System.out.println("------------------");
        //          _______1______
        //         /              \
        //     ___2__              3_
        //    /      \               \
        //   4      _5                6
        //         /
        //       _7
        //      /
        //     8
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        root.left.right.left.left = new TreeNode(8);
        System.out.println(isBalancedTree(root));
    }

    // 二叉树任意节点的左右子树的深度相差不超过1
    public static boolean isBalancedTree(TreeNode root) {
        return doIsBalancedTree(root) != -1;
    }

    private static int doIsBalancedTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = doIsBalancedTree(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = doIsBalancedTree(root.right);
        if (rightDepth == -1) {
            return -1;
        }

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        } else {
            return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
        }
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
