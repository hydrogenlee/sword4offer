package sword4offer.chapter2;

import java.util.Stack;

public class 用两个栈实现队列 {
    public static void main(String[] args) {
        Solution solution = new 用两个栈实现队列().new Solution();
        solution.push(0);
        solution.push(1);
        solution.push(2);
        solution.push(3);
        solution.push(4);

        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
    }

    class Solution {
        private Stack<Integer> stack1 = new Stack<Integer>();
        private Stack<Integer> stack2 = new Stack<Integer>();
        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.isEmpty()) {
                throw new IndexOutOfBoundsException("队列已空，无法删除");
            }
            return stack2.pop();
        }
    }
}
