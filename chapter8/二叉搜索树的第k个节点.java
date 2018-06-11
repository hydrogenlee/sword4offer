package sword4offer.chapter8;

import sword4offer.util.TreeNode;

public class 二叉搜索树的第k个节点 {
    // 找出第k大的节点
    public static void main(String[] args) {
        //         _______5______
        //        /              \
        //     ___3__          ___7__
        //    /      \        /      \
        //   2        4      6       8
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        Solution solution = new 二叉搜索树的第k个节点().new Solution();
        TreeNode result;

        System.out.println((result = solution.getKthNode(root, 1)) == null ? "null" : result.val);       // 2
        System.out.println((result = solution.getKthNode(root, 2)) == null ? "null" : result.val);       // 3
        System.out.println((result = solution.getKthNode(root, 3)) == null ? "null" : result.val);       // 4
        System.out.println((result = solution.getKthNode(root, 4)) == null ? "null" : result.val);       // 5
        System.out.println((result = solution.getKthNode(root, 5)) == null ? "null" : result.val);       // 6
        System.out.println((result = solution.getKthNode(root, 6)) == null ? "null" : result.val);       // 7
        System.out.println((result = solution.getKthNode(root, 7)) == null ? "null" : result.val);       // 8
        System.out.println((result = solution.getKthNode(root, 8)) == null ? "null" : result.val);       // "null"
        System.out.println((result = solution.getKthNode(root, 0)) == null ? "null" : result.val);       // "null"
        System.out.println((result = solution.getKthNode(root, -1)) == null ? "null" : result.val);      // "null"

    }

    class Solution {
        private int index = 1;
        // 使用中序遍历
        public TreeNode getKthNode(TreeNode pRoot, int k) {
            if (pRoot == null || k <= 0) {
                return null;
            }

            TreeNode result = null;

            if (pRoot.left != null) {
                result = getKthNode(pRoot.left, k);
            }
            if (index++ == k) {
                return pRoot;
            }
            if (result == null && pRoot.right != null) {
                result = getKthNode(pRoot.right, k);
            }

            return result;
        }
    }
}

