package sword4offer.chapter2;

import java.util.LinkedList;
import java.util.Queue;

public class 使用两个队列实现一个栈 {

    static Queue<Integer> queue1 = new LinkedList<>();
    static Queue<Integer> queue2 = new LinkedList<>();

    public static void main(String[] args) {
        push(0);
        push(1);
        push(2);
        push(3);
        push(4);

        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }

    public static void push(int node) {
        if (!queue1.isEmpty()) {
            queue1.add(node);
        } else {
            queue2.add(node);
        }
    }

    public static int pop() {
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
