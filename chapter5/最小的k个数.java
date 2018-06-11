package sword4offer.chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 最小的k个数 {
    public static void main(String[] args) {
        Solution solution = new 最小的k个数().new Solution();
        printList(solution.getLeastNumbers1(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4));
        System.out.println("---------------------------");
        printList(solution.getLeastNumbers2(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4));
        System.out.println("---------------------------");
        printList(solution.getLeastNumbers3(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4));
    }

    private static void printList(ArrayList<Integer> list) {
        for (Integer i : list) {
            System.out.printf(i + " ");
        }
        System.out.println();
    }


    class Solution {
        // 基于partition的算法
        // T-C: O(N)
        // S-C: O(1)
        public  ArrayList<Integer> getLeastNumbers1(int[] input, int k) {
            if (input == null || input.length == 0 || k <= 0 || k > input.length) {
                return new ArrayList<>();
            }
            int start = 0;
            int end = input.length - 1;

            while (start < end) {
                int[] temp = partition(input, start, end);
                if (temp[0] < k && k < temp[1]) {
                    break;
                }
                if (temp[0] >= k) {
                    end = temp[0];
                }
                if (temp[1] <= k) {
                    start = temp[1];
                }
            }
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                result.add(input[i]);
            }
            return result;
        }

        private int[] partition(int[] input, int start, int end) {
            if (input == null || input.length == 0 || start > end
                    || start < 0 || start >= input.length || end < 0 || end >= input.length) {
                throw new IllegalArgumentException("输入的参数有误");
            }
            int mid = input[(int) (start + Math.random() * (end - start + 1))];
            int lessIndex = start - 1;
            int moreIndex = end + 1;
            int cur = start;
            while (cur < moreIndex) {
                if (input[cur] == mid) {
                    cur++;
                } else if (input[cur] < mid) {
                    swap(input, cur++, ++lessIndex);
                } else {
                    swap(input, cur, --moreIndex);
                }
            }

            return new int[]{lessIndex, moreIndex};
        }

        private void swap(int[] array, int index1, int index2) {
            if (array == null || array.length == 0 || index1 == index2 || index1 < 0 ||
                    index1 >= array.length || index2 < 0 || index2 >= array.length) {
                return;
            }

            array[index1] ^= array[index2];
            array[index2] ^= array[index1];
            array[index1] ^= array[index2];
        }

        // 使用大根堆的思想，剩下的k个数就是需要求的值
        public ArrayList<Integer> getLeastNumbers2(int[] input, int k) {
            if (input == null || input.length == 0 || k < 0 || k > input.length) {
                return new ArrayList<>();
            }

            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            for (int i = 0; i < input.length; i++) {
                if (queue.size() < k) {
                    queue.add(input[i]);
                } else if (queue.size() == k) {
                    queue.add(input[i]);    // 先加入，再删除堆顶元素
                    queue.poll();
                }
            }

            ArrayList<Integer> result = new ArrayList<>();
            while (!queue.isEmpty()) {
                result.add(queue.poll());
            }
            return result;
        }

        // 直接排序然后返回前k个数，最简单的想法
        // T-C: O(N*logN)
        // S-C: O(1)
        public ArrayList<Integer> getLeastNumbers3(int[] input, int k) {
            if (input == null || input.length == 0 || k <= 0 || k > input.length) {
                return new ArrayList<>();
            }
            Arrays.sort(input);
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                result.add(input[i]);
            }
            return result;
        }
    }
}
