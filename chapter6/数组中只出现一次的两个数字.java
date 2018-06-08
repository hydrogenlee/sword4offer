package sword4offer.chapter6;

import java.util.HashMap;
import java.util.Map;

public class 数组中只出现一次的两个数字 {
    public static void main(String[] args) {
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        findNumsAppearOnce1(new int[]{2, 4, 3, 6, 3, 2, 5, 5}, num1, num2);
        System.out.println("num1: " + num1[0] + "\tnum2: " + num2[0]);
        System.out.println("-------------------------------------");
        num1[0] = -1;
        num2[0] = -1;
        findNumsAppearOnce2(new int[]{2, 4, 3, 6, 3, 2, 5, 5}, num1, num2);
        System.out.println("num1: " + num1[0] + "\tnum2: " + num2[0]);
    }

    // 二进制的异或运算
    // 性质：任何数异或自己的结果为0
    // 如果数组中只有一个数字出现了一次，其他的数字出现了两次，
    // 那么从头到尾异或所有的数字， 结果就是只出现一次的数字
    // T-C: O(N)
    // S-C: O(1)
    public static void findNumsAppearOnce1(int[] array,int[] num1, int[] num2) {
        if (array == null || array.length == 0) {
            return;
        }
        if (array.length == 1) {
            num1[0] = array[0];
            num2[0] = array[0];
        }
        int xorResult = array[0];
        for (int i = 1; i < array.length; i++) {
            xorResult ^= array[i];
        }

        // 因为xor肯定至少有一位为1
        // 找到xor中第一个为1的位
        int andResult = 1;
        while ((andResult & xorResult) != andResult) {
            andResult <<= 1;
        }

        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & andResult) == andResult) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    // 使用HashMap存储数字
    // T-C: O(N)
    // S-C: O(N)
    public static void findNumsAppearOnce2(int[] array,int[] num1, int[] num2) {
        if (array == null || array.length == 0) {
            return;
        }
        if (array.length == 1) {
            num1[0] = array[0];
            num2[0] = array[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        int[] result = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result[index++] = entry.getKey();
            }
        }

        num1[0] = result[0];
        num2[0] = result[1];
    }
}
