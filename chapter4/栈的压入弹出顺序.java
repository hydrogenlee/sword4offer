package sword4offer.chapter4;

import java.util.Stack;

public class 栈的压入弹出顺序 {
    public static void main(String[] args) {
        System.out.println(isPopOrder(new int[]{1, 2, 3, 4, 5},
                new int[]{4, 5, 3, 2, 1}));
        System.out.println(isPopOrder(new int[]{1, 2, 3, 4, 5},
                new int[]{4, 3, 5, 1, 2}));
        System.out.println(isPopOrder(new int[]{1, 2, 3, 4, 5},
                new int[]{4, 5, 3, 2, 6}));
    }

    public static boolean isPopOrder(int [] pushA, int [] popA) {
        if (pushA == null || popA == null) {
            return false;
        }
        if (pushA.length != popA.length) {
            return false;
        }
        if (pushA.length == 0 && popA.length == 0) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        while (popIndex < popA.length) {
            // 用于弹出栈顶元素
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
            // 用于将压栈序列压栈，直到等于出栈序列的当前值
            while (pushIndex < pushA.length) {
                if (pushA[pushIndex] != popA[popIndex]) {
                    stack.push(pushA[pushIndex]);
                    pushIndex++;
                } else {
                    pushIndex++;
                    popIndex++;
                    break;
                }
            }
            // 如果压栈序列已经全部压栈，并且栈顶元素等于出栈队列的当前元素，查找失败
            if (pushIndex == pushA.length &&
                    !stack.isEmpty() && stack.peek() != popA[popIndex]) {
                return false; // break;
            }
        }
        return stack.isEmpty();
    }
}
