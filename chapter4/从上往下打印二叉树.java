package sword4offer.chapter4;

import sword4offer.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 从上往下打印二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        // 8 6 10 5 7 9 11
        Solution solution = new 从上往下打印二叉树().new Solution();
        ArrayList<Integer> result = solution.printFromTopToBottom(root);
        for (Integer i : result) {
            System.out.printf(i + " ");
        }
        System.out.println();
    }

    class Solution {
        public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            // 层次遍历，广度优先搜索
            ArrayList<Integer> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            return list;
        }
    }
}
