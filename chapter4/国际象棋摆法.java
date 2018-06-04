package sword4offer.chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * 在nxn的国际象棋上排放n个皇后，使其不能相互攻击，即任意两个皇后不得处在同一行
 * 同一列和同意对角线上，请问有多少种符合条件的摆法
 */
public class 国际象棋摆法 {
    public static void main(String[] args) {
        System.out.println(queen(0, new int[]{}));   // 0
        System.out.println("----------------------------");
        System.out.println(queen(1, new int[]{1}));   // 1
        System.out.println("-----------------------------");
        System.out.println(queen(8, new int[]{1, 2, 3, 4, 5, 6, 7, 8}));   // 92
    }

    private static int queen(int n, int[] array) {
        if (n <= 0 || array == null || array.length == 0 || array.length != n) {
            return 0;
        }
        List<List<Integer>> result = new ArrayList<>();
        doPermutation(result, new ArrayList<>(), array, 0);

        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.printf(i + " ");
            }
            System.out.println();
        }


        return result.size();
    }

    private static void doPermutation(List<List<Integer>> result, List<Integer> solution, int[] array, int start) {
        if (start == array.length) {
            if (check(solution)) {
                List<Integer> temp = new ArrayList<>(solution);
                result.add(temp);           //因为不可能有重复， 所以不需要查重
            }
            return;
        }

        for (int i = start; i < array.length; i++) {
            if (i != start) {
                swap(array, i, start);
            }
            solution.add(array[start]);
            doPermutation(result, solution, array, start + 1);
            solution.remove(solution.size() - 1);
            if (i != start) {
                swap(array, i, start);
            }
        }
    }


    private static boolean check(List<Integer> solution) {
        if (solution == null) {
            return false;
        }

        for (int i = 0; i < solution.size() - 1; i++) {
            for (int j = i + 1; j < solution.size(); j++) {
                if (Math.abs(i - j) == Math.abs(solution.get(i) - solution.get(j))) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void swap(int[] array, int index1, int index2) {
        if (array == null || index1 < 0 || index1 >= array.length || index2 < 0 || index2 >= array.length) {
            return;
        }

        array[index1] ^= array[index2];
        array[index2] ^= array[index1];
        array[index1] ^= array[index2];
    }
}

