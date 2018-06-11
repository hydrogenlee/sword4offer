package sword4offer.chapter8;

import sword4offer.util.TreeNode;

public class 序列化二叉树 {
    public static void main(String[] args) {
        //         _______1______
        //        /              \
        //      _2            ___3__
        //     /             /      \
        //    14             5       6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(14);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        Solution solution = new 序列化二叉树().new Solution();

        // "1,2,14,#,#,#,3,5,#,#,6,#,#"
        String result = solution.serialize(root);
        System.out.println("序列化之后的字符串：" + result);
        System.out.printf("前序遍历反序列化之后的二叉树: ");
        // 1 2 14 3 5 6
        preOrder(solution.deserialize(result));
        System.out.println();
    }

    // 前序遍历
    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.printf(root.val + " ");
        if (root.left != null) {
            preOrder(root.left);
        }

        if (root.right != null) {
            preOrder(root.right);
        }
    }

    class Solution {
        private int index = -1;
        // 将null节点用'#'表示
        public  String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            doSerialize(root, sb);
            return sb.toString();
        }

        private void doSerialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("#,");
                return;
            }
            sb.append(root.val);
            sb.append(",");     // 用','分隔字符，主要用于防止节点值大于等于10的情况
            doSerialize(root.left, sb);
            doSerialize(root.right, sb);
        }
        public TreeNode deserialize(String str) {
            if (str == null || str.length() == 0) {
                return null;
            }
            String[] strings = str.split(",");
            return doDeserialize(strings);
        }


        private TreeNode doDeserialize(String[] array) {
            index++;
            // 其实，index是不可能大于等于数组的长度，因为最后的两个字符肯定都是##，不可能越界
            if (index >= array.length || "#".equals(array[index])) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(array[index]));
            root.left = doDeserialize(array);
            root.right = doDeserialize(array);

            return root;
        }
    }



}
