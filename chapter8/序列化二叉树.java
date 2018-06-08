package sword4offer.chapter8;

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

        // "1,2,14,#,#,#,3,5,#,#,6,#,#"
        String result = serialize(root);
        System.out.println("序列化之后的字符串：" + result);
        System.out.printf("前序遍历反序列化之后的二叉树: ");
        // 1 2 14 3 5 6
        preOrder(deserialize(result));
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

    // 将null节点用'#'表示
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        doSerialize(root, sb);
        return sb.toString();
    }

    private static void doSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(",");     // 用，分隔字符
        doSerialize(root.left, sb);
        doSerialize(root.right, sb);
    }
    public static TreeNode deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] strings = str.split(",");
        return doDeserialize(strings);
    }

    private static int index = -1;          // 注意：提交的时候去掉static
    private static TreeNode doDeserialize(String[] array) {
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

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
