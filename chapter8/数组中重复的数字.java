package sword4offer.chapter8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 数组中重复的数字 {
    public static void main(String[] args) {
        Solution solution = new 数组中重复的数字().new Solution();
        int[] duplication = new int[1];
        if (solution.findDuplicateByArrayIndex(new int[]{3, 2, 1, 0, 2, 5, 3}, 7, duplication)) {
            System.out.println(duplication[0]);
        }
    }

    class Solution {
        // Parameters:
        //    numbers:     an array of integers
        //    length:      the length of array numbers
        //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
        //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
        //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
        // Return value:       true if the input is valid, and there are some duplications in the array number
        //                     otherwise false

        // 方法1：因为是任意一个，所以排序之后查找
        // 注意：找到的可能不是第一个重复的值
        // T-C: O(N*logN)
        // S-C: O(1)
        public boolean findDuplicateBySortingArray(int numbers[], int length, int[] duplication) {
            // 正常来说，java的数组是不要传length这个参数的，只有C/C++会传
            if (numbers == null || numbers.length == 0 || numbers.length != length) {
                return false;
            }

            Arrays.sort(numbers);
            boolean isDup = false;

            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] == numbers[i + 1]) {
                    isDup = true;
                    duplication[0] = numbers[i];
                    break;
                }
            }

            return isDup;
        }

        // 方法2 使用hash table
        // 注意：找到的可能不是第一个重复的值
        // T-C: O(N)
        // S-C: O(N)
        public boolean findDuplicateUsingHashTable(int[] numbers, int length, int[] duplication) {
            if (numbers == null || numbers.length == 0 || numbers.length != length) {
                return false;
            }

            boolean isDup = false;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < numbers.length; i++) {
                if (map.containsKey(numbers[i])) {
                    duplication[0] = numbers[i];
                    isDup = true;
                    break;
                } else {
                    map.put(numbers[i], 1);
                }
            }

            return isDup;
        }

        // 方法3 ：根据位置来判断数字重复
        // 注意这个提示： 在一个长度为n的数组里的所有数字都在0到n-1的范围内
        // T-C: O(N)
        // S-C: O(1)
        public boolean findDuplicateByArrayIndex(int[] numbers, int length, int[] duplication) {
            if (numbers == null || numbers.length == 0 || numbers.length != length) {
                return false;
            }
            boolean isDup = false;
            int index = 0;
            while (index < numbers.length) {
                if (numbers[index] == index) {
                    index++;
                    continue;
                }
                // 当前位置的值和索引不一样，交换
                // 一直换到一样的时候，才去更新index
                if (numbers[index] == numbers[numbers[index]]) {
                    duplication[0] = numbers[index];
                    isDup = true;
                    break;
                } else {
                    swap(numbers, index, numbers[index]);
                }
            }
            return isDup;
        }

        private void swap(int[] array, int index1, int index2) {
            if (array == null || array.length == 0 || index1 < 0 || index1 >= array.length ||
                    index2 < 0 || index2 >= array.length || index1 == index2) {
                return;
            }

            array[index1] ^= array[index2];
            array[index2] ^= array[index1];
            array[index1] ^= array[index2];
        }
    }

}
