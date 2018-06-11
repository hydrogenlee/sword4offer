package sword4offer.chapter8;

import sword4offer.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 按之字形顺序打印二叉树 {
    public static void main(String[] args) {
        Solution solution = new 按之字形顺序打印二叉树().new Solution();
        //                _________1________
        //               /                  \
        //           ___2__              ___3___
        //          /      \            /       \
        //      __4_      __5_       __6_      __7_
        //     /    \    /    \    /     \    /    \
        //    8      9  10    11  12     13  14    15
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);

        // 1
        // 3 2
        // 4 5 6 7
        // 15 14 13 12 11 10 9 8
        ArrayList<ArrayList<Integer>> result = solution.printUsingTwoStack(root);
        for (ArrayList<Integer> list : result) {
            for (Integer i : list) {
                System.out.printf(i + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------------");
        // 如果不需要返回，直接在函数里面打印
        solution.printDirectlyInFunctionUsingTwoStack(root);
    }

    class Solution {
        // 使用两个栈
        public ArrayList<ArrayList<Integer>> printUsingTwoStack(TreeNode pRoot) {
            if (pRoot == null) {
                return new ArrayList<>();
            }

            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            ArrayList<Integer> item = new ArrayList<>();
            Stack<TreeNode> stackOdd = new Stack<>();   // 奇数层
            Stack<TreeNode> stackEven = new Stack<>();  // 偶数层
            stackOdd.add(pRoot);
            item.add(pRoot.val);
            boolean isOdd = true;       // 判断是奇偶层
            boolean needPrint = true;   // 是否需要保存到list

            // 当两个栈都为空时保存到item中，但是没有保存到result中
            while (!stackOdd.isEmpty() || !stackEven.isEmpty()) {
                if (needPrint) {
                    result.add(new ArrayList<>(item));
                    item.clear();
                    needPrint = false;
                }
                if (isOdd) {
                    if (stackOdd.isEmpty()) {
                        isOdd = false;   // 改为偶数层
                        needPrint = true;
                    } else {
                        TreeNode top = stackOdd.pop();
                        // 先右再左
                        if (top.right != null) {
                            stackEven.push(top.right);
                            item.add(top.right.val);
                        }
                        if (top.left != null) {
                            stackEven.push(top.left);
                            item.add(top.left.val);
                        }
                    }
                } else {
                    if (stackEven.isEmpty()) {
                        isOdd = true;
                        needPrint = true;
                    } else {
                        TreeNode top = stackEven.pop();
                        // 先左再右
                        if (top.left != null) {
                            stackOdd.add(top.left);
                            item.add(top.left.val);
                        }
                        if (top.right != null) {
                            stackOdd.add(top.right);
                            item.add(top.right.val);
                        }
                    }
                }
            }
            return result;
        }


        //使用两个栈，但是直接在函数内部打印
        public void printDirectlyInFunctionUsingTwoStack(TreeNode pRoot) {
            if (pRoot == null) {
                return;
            }

            Stack<TreeNode> stackOdd = new Stack<>();
            Stack<TreeNode> stackEven = new Stack<>();
            boolean isOdd = true;           // 奇偶层
            stackOdd.add(pRoot);
            System.out.println(pRoot.val);  // 打印第一层

            while (!stackOdd.isEmpty() || !stackEven.isEmpty()) {
                if (isOdd) {
                    if (stackOdd.isEmpty()) {
                        System.out.println();
                        isOdd = false;
                    } else {
                        TreeNode top = stackOdd.pop();
                        // 先右后左
                        if (top.right != null) {
                            stackEven.push(top.right);
                            System.out.printf(top.right.val + " ");
                        }
                        if (top.left != null) {
                            stackEven.push(top.left);
                            System.out.printf(top.left.val + " ");
                        }

                    }
                } else {
                    if (stackEven.isEmpty()) {
                        System.out.println();
                        isOdd = true;
                    } else {
                        TreeNode top = stackEven.pop();
                        if (top.left != null) {
                            stackOdd.push(top.left);
                            System.out.printf(top.left.val + " ");
                        }
                        if (top.right != null) {
                            stackOdd.push(top.right);
                            System.out.printf(top.right.val + " ");
                        }
                    }
                }
            }
        }


        // 使用队列
        // 通过null来分层
        public ArrayList<ArrayList<Integer>> printUsingQueue(TreeNode pRoot) {
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
                    if (result.size() % 2 == 0) {
                        // 正序
                        result.add(new ArrayList<>(item));
                    } else {
                        // 逆序
                        ArrayList<Integer> temp = new ArrayList<>();
                        for (int i = item.size() - 1; i >= 0; i--) {
                            temp.add(item.get(i));
                        }
                        result.add(temp);
                    }

                    item.clear();
                    queue.add(null);
                    if (queue.size() == 1) {
                        // 只有一个null时，跳出循环，防止死循环
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
    }


}
