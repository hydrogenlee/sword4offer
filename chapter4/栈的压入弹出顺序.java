package sword4offer.chapter4;

import java.util.Stack;

public class 栈的压入弹出顺序 {
    public static void main(String[] args) {
        Solution solution = new 栈的压入弹出顺序().new Solution();
        System.out.println(solution.isPopOrder(new int[]{1, 2, 3, 4, 5},
                new int[]{4, 5, 3, 2, 1}));
        System.out.println(solution.isPopOrder(new int[]{1, 2, 3, 4, 5},
                new int[]{4, 3, 5, 1, 2}));
        System.out.println(solution.isPopOrder(new int[]{1, 2, 3, 4, 5},
                new int[]{4, 5, 3, 2, 6}));
    }

    class Solution {
        public boolean isPopOrder(int [] pushA, int [] popA) {
            if (pushA == null || popA == null) {
                return pushA == null && popA == null;
            }
            if (pushA.length != popA.length) {
                return false;
            }

            Stack<Integer> stack = new Stack<>();
            int index = 0;
            for (int i = 0; i < pushA.length; i++) {
                stack.push(pushA[i]);
                while (!stack.isEmpty() && stack.peek() == popA[index]) {
                    stack.pop();
                    index++;
                }
            }
            return stack.isEmpty();
        }
    }
}
