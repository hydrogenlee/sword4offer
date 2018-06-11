package sword4offer.chapter2;

import java.util.LinkedList;
import java.util.Queue;

public class 使用两个队列实现一个栈 {
    public static void main(String[] args) {
        Solution solution = new 使用两个队列实现一个栈().new Solution();
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
        private Queue<Integer> queue1 = new LinkedList<>();
        private Queue<Integer> queue2 = new LinkedList<>();
        public void push(int node) {
            if (!queue1.isEmpty()) {
                queue1.add(node);
            } else {
                queue2.add(node);
            }
        }

        public int pop() {
            if (queue1.isEmpty() && queue2.isEmpty()) {
                throw new RuntimeException("栈为空，无法弹出数据");
            }
            int temp = 0;
            if (queue1.isEmpty()) {
                while (!queue2.isEmpty()) {
                    temp = queue2.poll();
                    if (!queue2.isEmpty()) {
                        queue1.add(temp);
                    }
                }
            } else {
                while (!queue1.isEmpty()) {
                    temp = queue1.poll();
                    if (!queue1.isEmpty()) {
                        queue2.add(temp);
                    }
                }
            }
            return temp;
        }
    }
}
