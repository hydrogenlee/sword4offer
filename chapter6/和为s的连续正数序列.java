package sword4offer.chapter6;

import java.util.ArrayList;

public class 和为s的连续正数序列 {
    public static void main(String[] args) {
        printList(findContinuousSequence(15));
        System.out.println("-----------------");
        printList(findContinuousSequence(100));
        System.out.println("==============Optimized===============");
        printList(findContinuousSequenceOptimized(15));
        System.out.println("-----------------");
        printList(findContinuousSequenceOptimized(100));

    }

    private static void printList(ArrayList<ArrayList<Integer>> lists) {
        if (lists == null || lists.size() == 0) {
            return;
        }

        for (ArrayList<Integer> list : lists) {
            for (Integer i : list) {
                System.out.printf(i + " ");
            }
            System.out.println();
        }
    }


    // 这是下面函数的优化版本
    public static ArrayList<ArrayList<Integer>> findContinuousSequenceOptimized(int sum) {
        if (sum <= 2) {
            // 因为至少包含两个正数，所以序列的最小值为3（1,2）
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int leftIndex = 1;
        int rightIndex = 2;
        int tempSum = leftIndex;

        while (leftIndex <= sum / 2) {
            // 这里不是每次都从头开始了，而是根据递增序列的性质，来分别增加leftIndex和rightIndex的值
            while (tempSum <= sum) {
                if (tempSum == sum) {
                    ArrayList<Integer> solution = new ArrayList<>();
                    for (int i = leftIndex; i < rightIndex; i++) {
                        solution.add(i);
                    }
                    result.add(solution);
                }
                // 注意: 这里当temp == sum时，也往右移动了一步
                tempSum += rightIndex++;
            }
            // 说明temp > sum，此时将leftIndex右移
            tempSum -= leftIndex++;
        }
        return result;
    }


    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        if (sum <= 2) {
            // 因为至少包含两个正数，所以序列的最小值为3（1,2）
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int leftIndex = 1;

        while (leftIndex <= sum / 2) {
            int tempSum = leftIndex;
            int rightIndex = leftIndex + 1;
            while (tempSum <= sum) {
                if (tempSum == sum) {
                    ArrayList<Integer> solution = new ArrayList<>();
                    for (int i = leftIndex; i < rightIndex; i++) {
                        solution.add(i);
                    }
                    result.add(solution);
                    break;
                } else {
                    tempSum += rightIndex;
                    rightIndex++;
                }
            }
            leftIndex++;
        }

        return result;
    }
}
