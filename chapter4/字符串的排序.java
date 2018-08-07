package sword4offer.chapter4;

import java.util.ArrayList;
import java.util.Collections;

public class 字符串的排序 {
    public static void main(String[] args) {
        Solution solution = new 字符串的排序().new Solution();
        ArrayList<String> result = solution.permutation("abbc");
        for (String s : result) {
            System.out.println(s);
        }
    }

    class Solution {
        public ArrayList<String> permutation(String str) {
            if (str == null || "".equals(str)) {
                return new ArrayList<>();
            }

            ArrayList<String> result = new ArrayList<>();

            doPermutation(result, str.toCharArray(), 0);
            Collections.sort(result); // 对结果排序
            return result;
        }

        private void doPermutation(ArrayList<String> result, char[] array, int start) {
            if (start == array.length) {
                String s = String.valueOf(array);
                // 去重
                if (!result.contains(s)) {
                    result.add(s);
                }
                return;
            }

            for (int i = start; i < array.length; i++) {
                // 先交换
                swap(array, start, i);
                doPermutation(result, array, start + 1);
                // 再交换回去
                swap(array, i, start);
            }
        }

        private void swap(char[] array, int index1, int index2) {
            if (array == null || index1 < 0 || index1 >= array.length ||
                    index2 < 0 || index2 >= array.length || index1 == index2) {
                return;
            }

            array[index1] ^= array[index2];
            array[index2] ^= array[index1];
            array[index1] ^= array[index2];
        }
    }
}
