package sword4offer.chapter6;

import java.util.ArrayList;

public class 和为s的两个数字 {
    public static void main(String[] args) {
        ArrayList<Integer> result = findNumbersWithSum(new int[]{0, 1, 2, 4, 7, 11, 15}, 15);
        if (result.size() == 2) {
            System.out.println("两个数为：" + result.get(0) + ", " + result.get(1));
        }
    }

    // 如果有多对数字的和等于S，输出两个数的乘积最小的。
    public static ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        if (array == null || array.length < 2) {
            return new ArrayList<>();
        }

        int leftIndex = 0;
        int rightIndex = array.length - 1;
        // 保证 num1+num2 ！= sum
        int num1 = 0;
        int num2 = sum - 1;
        long multiple = Long.MAX_VALUE;

        while (leftIndex < rightIndex) {
            int tempSum = array[leftIndex] + array[rightIndex];
            if (tempSum == sum) {
                long templeMultiple = array[leftIndex] * array[rightIndex];
                if (templeMultiple < multiple) {
                    num1 = array[leftIndex];
                    num2 = array[rightIndex];
                    multiple = templeMultiple;
                }
                leftIndex++;
                rightIndex--;
            } else if (tempSum > sum) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        if (num1 + num2 == sum) {
            result.add(num1);
            result.add(num2);
        }
        return result;
    }
}
