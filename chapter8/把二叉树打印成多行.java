package sword4offer.chapter8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 把二叉树打印成多行 {
    //         _______8______
    //        /              \
    //     ___6__          ___10__
    //    /      \        /       \
    //   5       7       9        11
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);

        ArrayList<ArrayList<Integer>> result = print(root);
        for (ArrayList<Integer> list : result) {
            for (Integer i: list) {
                System.out.printf(i + " ");
            }
            System.out.println();
        }
    }


    // 通过null来分层
    public static ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> item = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            if (head == null) {
                result.add(new ArrayList<>(item));
                item.clear();
                queue.add(null);
                if (queue.size() == 1) {
                    // 说明只有一个null了，防止一直循环
                    break;
                }
                continue;
            }
            item.add(head.val);
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
        }
        return result;
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
