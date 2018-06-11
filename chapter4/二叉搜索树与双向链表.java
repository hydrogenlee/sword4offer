package sword4offer.chapter4;

import sword4offer.util.TreeNode;

public class 二叉搜索树与双向链表 {
    public static void main(String[] args) {
        Solution solution = new 二叉搜索树与双向链表().new Solution();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);

        TreeNode result = solution.convert2(root);

        while (result != null) {
            System.out.printf(result.val + " ");
            result = result.right;
        }
        System.out.println();
    }

    class Solution {
        // 这种方法思路比较清晰
        public TreeNode convert2(TreeNode pRootOfTree) {
            if (pRootOfTree == null) {
                return null;
            }
            TreeNode result = doConvert2(pRootOfTree, null);

            while (result != null && result.left != null) {
                result = result.left;
            }
            return result;
        }

        private TreeNode doConvert2(TreeNode pRootOfTree, TreeNode lastNode) {
            if (pRootOfTree == null) {
                return null;
            }
            // 左子树
            if (pRootOfTree.left != null) {
                lastNode = doConvert2(pRootOfTree.left, lastNode);
            }
            // 处理节点
            if (lastNode == null) {
                lastNode = pRootOfTree;
            } else {
                lastNode.right = pRootOfTree;
                pRootOfTree.left = lastNode;
                lastNode = lastNode.right;      // 指向下一个
            }
            // 右子树
            if (pRootOfTree.right != null) {
                lastNode = doConvert2(pRootOfTree.right, lastNode);
            }
            return lastNode;
        }


        // 分析的比较复杂，但是也能通过
        public TreeNode convert1(TreeNode pRootOfTree) {
            if (pRootOfTree == null) {
                return null;
            }
            return doConvert1(pRootOfTree, pRootOfTree);
        }

        private TreeNode doConvert1(TreeNode pRootOfTree, TreeNode priorRoot) {
            if (pRootOfTree == null) {
                return null;
            }

            if (pRootOfTree.left != null) {
                TreeNode tempLeft = doConvert1(pRootOfTree.left, priorRoot);
                tempLeft.right = pRootOfTree;
                pRootOfTree.left = tempLeft;
            }

            if (pRootOfTree.right != null) {
                TreeNode tempRight = doConvert1(pRootOfTree.right, priorRoot);
                tempRight.left = pRootOfTree;
                pRootOfTree.right = tempRight;
            }

            TreeNode result = null;

            if (pRootOfTree.val < priorRoot.val) {
                // 左子树
                result = pRootOfTree.right == null ? pRootOfTree : pRootOfTree.right;
            } else if (pRootOfTree.val > priorRoot.val) {
                // 右子树
                result = pRootOfTree.left == null ? pRootOfTree : pRootOfTree.left;
            } else {
                // 说明最开始的根节点
                while (pRootOfTree != null) {
                    result = pRootOfTree;
                    pRootOfTree = pRootOfTree.left;
                }
            }
            return result;
        }
    }
}
