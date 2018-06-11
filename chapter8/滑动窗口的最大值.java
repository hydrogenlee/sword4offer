package sword4offer.chapter8;

import java.util.ArrayList;
import java.util.LinkedList;

public class 滑动窗口的最大值 {
    public static void main(String[] args) {
        Solution solution = new 滑动窗口的最大值().new Solution();
        ArrayList<Integer> result = solution.maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3);
        // 结果： 4 4 6 6 6 5
        for (Integer i : result) {
            System.out.printf(i + " ");
        }
        System.out.println("\n-----------------------");
        result = solution.maxInWindows(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        // 结果： 3 3 5 5 6 7
        for (Integer i : result) {
            System.out.printf(i + " ");
        }
        System.out.println("\n----------------------");

        result = solution.maxInWindows(new int[]{10, 14, 12, 11}, 1);
        // 结果： 10 14 12 11
        for (Integer i : result) {
            System.out.printf(i + " ");
        }
        System.out.println("\n----------------------");
        result = solution.maxInWindows(new int[]{16, 14, 12, 10, 8, 6, 4}, 5);
        // 结果： 16 14 12
        for (Integer i : result) {
            System.out.printf(i + " ");
        }
        System.out.println();
    }

    class Solution {
        // 思路：队列中不存数组的值，而是存滑动窗口的可能最大值
        //      使用双端队列，队头和队尾都可以删除
        //      如果，当前值大于队列头部最大值，那么将队列清空，然后将最大值加入队列
        //      如果，如果当前值小于等于滑动窗口的最大值，将元素加入队尾（需要从队尾删除小于当前值的值）
        public ArrayList<Integer> maxInWindows(int[] num, int size) {
            if (num == null || num.length == 0 || size <= 0 || size > num.length) {
                return new ArrayList<>();
            }

            ArrayList<Integer> result = new ArrayList<>();
            LinkedList<Integer> queue = new LinkedList<>();

            for (int index = 0; index < num.length; index++) {
                if (queue.isEmpty()) {
                    queue.add(num[index]);
                } else {
                    if (num[index] > queue.peek()) {
                        // 此时，说明队列中的所有数值都不可能成为最大值
                        queue.clear();
                        queue.add(num[index]);
                    } else {
                        // 说明可能成为最大值，因此加到队列的尾部，同时删除队列中小于当前值的元素
                        while (queue.getLast() < num[index]) {
                            queue.removeLast();
                        }
                        queue.addLast(num[index]);
                        // 如果，当前滑动窗口，已经不包括当前队列的队头元素，删除
                        if (index - size >= 0 && queue.peek() == num[index - size]) {
                            queue.poll();
                        }
                    }
                }
                if (index >= size - 1) {
                    result.add(queue.peek());
                }
            }
            return result;
        }
    }
}
