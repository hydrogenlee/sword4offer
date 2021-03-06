package sword4offer.chapter6;

import sword4offer.util.TreeNode;

public class 二叉树的深度 {
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

        Solution solution = new 二叉树的深度().new Solution();
        System.out.println(solution.getTreeDepth(root));            // 4
    }

    class Solution {
        public int getTreeDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftDepth = getTreeDepth(root.left);
            int rightDepth = getTreeDepth(root.right);

            return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
        }
    }


}
