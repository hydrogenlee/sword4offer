package sword4offer.chapter7;

import sword4offer.util.TreeNode;

public class 二叉搜索树中两个节点的最低公共祖先 {
    // root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
    //         _______6______
    //        /              \
    //     ___2__          ___8__
    //    /      \        /      \
    //   0      _4       7       9
    //         /  \
    //        3   5
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        Solution solution = new 二叉搜索树中两个节点的最低公共祖先().new Solution();

        // 默认root不为空
        System.out.println(solution.lowestCommonAncestor(root, root.left, root.right).val);           // 2 和 8, 结果为6
        System.out.println(solution.lowestCommonAncestor(root, root.left, root.left.right).val);      // 2 和 4，结果为2

    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }

            // p为节点值小的，q为节点值大的
            if (p.val > q.val) {
                // 交换
                TreeNode temp = p;
                p = q;
                q = temp;
            }

            TreeNode temp = root;
            while (temp != null) {
                if (p.val == temp.val || q.val == temp.val ||
                        (p.val < temp.val && q.val > temp.val)) {
                    // 如果某个节点是当前的根节点（temp），那么最低公共祖先就是此节点
                    // 或者是一个节点的值小于当前根节点（temp）的值，另一个节点大于此节点的值
                    break;
                } else if (p.val < temp.val && q.val < temp.val) {
                    // 往左子树查找
                    temp = temp.left;
                } else if (p.val > temp.val && q.val > temp.val) {
                    // 往右子树查找
                    temp = temp.right;
                }
            }

            return temp;
        }
    }
}
