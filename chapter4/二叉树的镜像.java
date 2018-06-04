package sword4offer.chapter4;

import java.util.Stack;

public class 二叉树的镜像 {
//    二叉树的镜像定义：
//       源二叉树
//    	    8
//    	   /  \
//    	  6   10
//    	 / \  / \
//    	5  7 9 11
//    	镜像二叉树
//    	    8
//    	   /  \
//    	  10   6
//    	 / \  / \
//    	11 9 7  5
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        getMirror(root);
        printTree(root);
        System.out.println("------------------------------------");
        getMirror(root);
        getMirrorUsingStack(root);
        printTree(root);
    }


    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        if (root.left != null) {
            printTree(root.left);
        }

        if (root.right != null) {
            printTree(root.right);
        }
    }

    // 使用循环的方法
    private static void getMirrorUsingStack(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (stack.size() != 0) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            // 交换左右两个节点
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }


    // 使用递归的方法
    public static void getMirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        root = doGetMirror(root);
    }

    private static TreeNode doGetMirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        TreeNode left = doGetMirror(root.left);
        TreeNode right = doGetMirror(root.right);

        root.left = right;
        root.right = left;

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
