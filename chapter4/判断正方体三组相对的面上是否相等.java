package sword4offer.chapter4;

import java.util.ArrayList;

/**
 * 输入一个含有8个数字的数组，判断有没有可能把这8个数组分别放在正方形的8个顶点上，
 * 使得正方形上三组相对的面上的4个顶点的和都相等
 */
public class 判断正方体三组相对的面上是否相等 {
    public static void main(String[] args) {
        Solution solution = new 判断正方体三组相对的面上是否相等().new Solution();
        ArrayList<ArrayList<Integer>> result = solution.getSolution(new int[]{1, 2, 3, 4, 5, 6, 7, 8});

        for (ArrayList<Integer> list : result) {
            for (Integer i : list) {
                System.out.printf(i + " ");
            }
            System.out.println();
        }

        System.out.println("-------------------------------");
        result =solution.getSolution(new int[]{1, 1, 1, 1, 2, 2, 2, 2});

        for (ArrayList<Integer> list : result) {
            for (Integer i : list) {
                System.out.printf(i + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------");
        result = solution.getSolution(new int[]{1, 1, 1, 1, 1, 1, 1, 1});

        for (ArrayList<Integer> list : result) {
            for (Integer i : list) {
                System.out.printf(i + " ");
            }
            System.out.println();
        }
    }

    class Solution {
        public ArrayList<ArrayList<Integer>> getSolution(int[] numbers) {
            if (numbers == null || numbers.length != 8) {
                return new ArrayList<>();
            }
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            doPermutation(result, new ArrayList<>(), numbers, 0);
            return result;
        }

        private void doPermutation(ArrayList<ArrayList<Integer>> result,
                                          ArrayList<Integer> pos, int[] numbers, int start){
            if (start == numbers.length) {
                // 假设正方形的上面四个顶点是a0, a1, a2, a3
                // 下面的四个顶点是a4, a5, a6, a7
                ArrayList<Integer> temp = new ArrayList<>(pos);
                if (! result.contains(temp)) {
                    int a0 = temp.get(0);
                    int a1 = temp.get(1);
                    int a2 = temp.get(2);
                    int a3 = temp.get(3);
                    int a4 = temp.get(4);
                    int a5 = temp.get(5);
                    int a6 = temp.get(6);
                    int a7 = temp.get(7);
                    if (a0 + a1 + a2 + a3 == a4 + a5 + a6 + a7 &&
                            a0 + a2 + a4 + a6 == a1 + a3 + a5 + a7 &&
                            a0 + a1 + a4 + a5 == a2 + a3 + a6 + a7) {
                        result.add(temp);
                    }
                }
                return;
            }

            for (int i = start; i < numbers.length; i++) {
                if (i != start) {
                    // swap
                    swap(numbers, start, i);
                }
                pos.add(numbers[start]);
                doPermutation(result, pos, numbers, start + 1);
                pos.remove(pos.size() - 1);
                if (i != start) {
                    // swap
                    swap(numbers, start, i);
                }
            }
        }

        private void swap(int[] numbers, int index1, int index2) {
            if (numbers == null || index1 < 0 || index1 >= numbers.length || index2 < 0 || index2 >= numbers.length) {
                return;
            }
            numbers[index1] ^= numbers[index2];
            numbers[index2] ^= numbers[index1];
            numbers[index1] ^= numbers[index2];
        }
    }
}
