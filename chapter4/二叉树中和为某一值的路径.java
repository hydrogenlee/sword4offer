package sword4offer.chapter4;

import sword4offer.util.TreeNode;

import java.util.ArrayList;

public class 二叉树中和为某一值的路径 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        Solution solution = new 二叉树中和为某一值的路径().new Solution();
        ArrayList<ArrayList<Integer>> result = solution.findPath(root, 22);

        // print
        for (ArrayList<Integer> list : result) {
            for (Integer i : list) {
                System.out.printf(i + " ");
            }
            System.out.println();
        }
    }

    class Solution {
        public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
            if (root == null) {
                return new ArrayList<>();
            }
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            doFindPath(root, result, new ArrayList<>(), 0, target);
            return result;
        }

        private void doFindPath(TreeNode root, ArrayList<ArrayList<Integer>> result,
                                      ArrayList<Integer> path, int current, int target) {
            // 需要到达最后一个节点
            if (root.left == null && root.right == null && current + root.val == target) {
                ArrayList<Integer> ans = new ArrayList<>(path);
                ans.add(root.val);
                result.add(ans);
                return;
            }

            // 其实是一个前序遍历
            // 加入该树的信息
            path.add(root.val);
            current += root.val;

            if (root.left != null) {
                doFindPath(root.left, result, path, current, target);
            }

            if (root.right != null) {
                doFindPath(root.right, result, path, current, target);
            }

            // 回溯
            path.remove(path.size() - 1);
        }
    }
}
