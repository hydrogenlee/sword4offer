package sword4offer.chapter7;

import sword4offer.util.TreeNode;

import java.util.Stack;

public class 二叉树中两个节点的最低公共祖先 {

    // 注意：不是二叉搜索树
    // root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    //         _______3______
    //        /              \
    //     ___5__          ___1__
    //    /      \        /      \
    //   6      _2       0       8
    //         /  \
    //        7   4
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        Solution solution = new 二叉树中两个节点的最低公共祖先().new Solution();
        // 默认root不为空
        System.out.println(solution.lowestCommonAncestor(root, root.left, root.right).val);              // 5 和 1, 结果为3
        System.out.println(solution.lowestCommonAncestor(root, root.left, root.left.right.right).val);   // 5 和 4, 结果为5
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }

            Stack<TreeNode> nodePathOfP = getNodePath(root, p);
            Stack<TreeNode> nodePathOfQ = getNodePath(root, q);

            TreeNode common = null;
            while (!nodePathOfP.isEmpty() && !nodePathOfQ.isEmpty()) {
                TreeNode tempP = nodePathOfP.pop();
                TreeNode tempQ = nodePathOfQ.pop();
                if (tempP != tempQ) {
                    break;
                } else {
                    common = tempP;
                }
            }
            return common;
        }

        private Stack<TreeNode> getNodePath(TreeNode root, TreeNode node) {
            if (root == null) {
                return null;
            }
            if (root.val == node.val) {
                Stack<TreeNode> result = new Stack<>();
                result.push(node);
                return result;
            }
            Stack<TreeNode> temp;
            if ((temp = getNodePath(root.left, node)) == null) {
                temp = getNodePath(root.right, node);       // 也可能等于0
            }
            if (temp != null) {
                temp.push(root);
            }
            return temp;
        }
    }
}
