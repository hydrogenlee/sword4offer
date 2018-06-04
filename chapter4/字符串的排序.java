package sword4offer.chapter4;

import java.util.ArrayList;
import java.util.Collections;

public class 字符串的排序 {
    public static void main(String[] args) {
        ArrayList<String> result = permutation("abbc");
        for (String s : result) {
            System.out.println(s);
        }
    }


    public static ArrayList<String> permutation(String str) {
        if (str == null || "".equals(str)) {
            return new ArrayList<>();
        }

        char[] array = str.toCharArray();
        ArrayList<String> result = new ArrayList<>();

        doPermutation(result, new StringBuilder(), array, 0);
        Collections.sort(result); // 对结果排序
        return result;
    }

    private static void doPermutation(ArrayList<String> result, StringBuilder sb,
                                      char[] array, int start) {
        if (start == array.length) {
            String s = sb.toString();
            // 去重
            if (!result.contains(s)) {
                result.add(s);
            }
            return;
        }

        for (int i = start; i < array.length; i++) {
            // 先交换
            if (i != start) {
                // swap
                swap(array, start, i);
            }
            doPermutation(result, sb.append(array[start]), array, start + 1);
            sb.delete(sb.length() - 1, sb.length());
            // 再交换回去
            if (i != start) {
                // swap
                swap(array, i, start);
            }
        }
    }

    private static void swap(char[] array, int index1, int index2) {
        if (array == null || index1 < 0 || index1 >= array.length ||
                index2 < 0 || index2 >= array.length) {
            return;
        }

        array[index1] ^= array[index2];
        array[index2] ^= array[index1];
        array[index1] ^= array[index2];
    }
}
