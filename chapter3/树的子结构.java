package sword4offer.chapter3;

public class 树的子结构 {
    public static void main(String[] args) {
        //        root1       root2
        //          8           8
        //        /  \         / \
        //       8    7       9  2
        //     /  \
        //   9     2
        //        / \
        //       4  7
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);

        System.out.println(hasSubtree(root1, root2));
    }

    // 我们约定空树不是任意一个树的子结构
    private static boolean hasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        // 两棵树都不空
        // 因为有短路操作的存在，不会全部都计算
        return isSubTree(root1, root2) ||
               hasSubtree(root1.left, root2) ||
               hasSubtree(root1.right, root2);
    }

    private static boolean isSubTree(TreeNode root1, TreeNode root2) {
//        if (root1 == null || root2 == null) {
//            // 还有root1为null，root2不为null时，返回false
//            return root1 != null || root2 == null;
//        }
        // 与上面注释的判断是相同的
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {        // 隐含条件是 root != null
            return false;
        }
        // 因为有短路操作的存在，不会全部都计算
        return root1.val == root2.val &&
               isSubTree(root1.left, root2.left) &&
               isSubTree(root1.right, root2.right);
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
