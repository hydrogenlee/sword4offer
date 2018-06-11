package sword4offer.chapter8;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 数据流中的中位数 {
    public static void main(String[] args) {
        // 原始序列：2 4 6 2 1 8 9 0 3
        // 中位数： 2 3 4 3 2 3 4 3 3
        Solution solution = new 数据流中的中位数().new Solution();
        solution.insert(2);
        System.out.println(solution.getMedian());   // 2
        solution.insert(4);
        System.out.println(solution.getMedian());   // 3
        solution.insert(6);
        System.out.println(solution.getMedian());   // 4
        solution.insert(2);
        System.out.println(solution.getMedian());   // 3
        solution.insert(1);
        System.out.println(solution.getMedian());   // 2
        solution.insert(8);
        System.out.println(solution.getMedian());   // 3
        solution.insert(9);
        System.out.println(solution.getMedian());   // 4
        solution.insert(0);
        System.out.println(solution.getMedian());   // 3
        solution.insert(3);
        System.out.println(solution.getMedian());   // 3
    }

    // 思路： 如果数字小于等于大根堆的堆顶元素，那么放入大根堆，如果大于，则放入小根堆
    //       并且保证大根堆中节点的数量只能比小根堆中节点的数量多一个或者相等，否则，进行调整
    class Solution {
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        public void insert(Integer num) {
            // 先往大根堆里面放
            if (maxHeap.size() == 0) {
                maxHeap.add(num);
                return;
            }
            if (num <= maxHeap.peek()) {
                // 往大根堆里面放
                if (maxHeap.size()  == minHeap.size() + 1) {
                    // 调整
                    minHeap.add(maxHeap.poll());
                }
                maxHeap.add(num);
            } else {
                if (minHeap.size() == maxHeap.size()) {
                    // 调整
                    if (num <= minHeap.peek()) {
                        maxHeap.add(num);
                    } else {
                        maxHeap.add(minHeap.poll());
                        minHeap.add(num);
                    }
                } else {
                    minHeap.add(num);
                }
            }
        }

        public Double getMedian() {
            if ((maxHeap.size() + minHeap.size()) % 2 == 0) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                return (double)maxHeap.peek();
            }
        }
    }
}
