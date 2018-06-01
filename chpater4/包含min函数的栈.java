package sword4offer.chpater4;

import java.util.Stack;

public class 包含min函数的栈 {
    public static void main(String[] args) {
        包含min函数的栈 stack = new 包含min函数的栈();
        stack.push(3);
        System.out.println(stack.top());
        System.out.println(stack.min());
        stack.push(6);
        System.out.println(stack.top());
        System.out.println(stack.min());
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.min());
    }

    private Stack<Integer> stackNumber = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();

    public void push(int node) {
        stackNumber.push(node);
        if (stackMin.isEmpty()) {
            stackMin.push(node);
        } else {
            stackMin.push(Math.min(node, stackMin.peek()));
        }
    }

    public void pop() {
        if (stackNumber.isEmpty() || stackMin.isEmpty()) {
            throw new RuntimeException("栈为空，不能执行pop操作");
        }
        stackNumber.pop();
        stackMin.pop();
    }

    public int top() {
        if (stackNumber.isEmpty() || stackMin.isEmpty()) {
            throw new RuntimeException("栈为空，不能执行top操作");
        }
        return stackNumber.peek();
    }

    public int min() {
        if (stackNumber.isEmpty() || stackMin.isEmpty()) {
            throw new RuntimeException("栈为空，不能执行min操作");
        }
        return stackMin.peek();
    }
}
