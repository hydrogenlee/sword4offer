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
                System.out.print(i + " ");
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
            doFindPath(result, new ArrayList<>(), root, 0, target);
            // result.sort((l1, l2) -> l2.size() - l1.size()); // 可能需要按照路径长度排序
            return result;
        }

        public void doFindPath(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path,
                               TreeNode root, int sum, int target) {
            // 只有当不是叶子节点，但是左右孩子不同时存在时，才执行下面这句
            if (root == null) {
                return;
            }
            // 到达叶子节点
            if (root.left == null && root.right == null) {
                if(sum + root.val == target) {
                    ArrayList<Integer> temp = new ArrayList<>(path);
                    temp.add(root.val);
                    result.add(temp);
                }
                return;
            }
            // 采用回溯法
            path.add(root.val);
            doFindPath(result, path, root.left, sum + root.val, target);
            doFindPath(result, path, root.right, sum + root.val, target);
            // 回溯
            path.remove(path.size() - 1);
        }
    }
}
