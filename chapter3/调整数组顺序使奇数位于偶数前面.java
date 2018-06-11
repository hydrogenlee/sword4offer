package sword4offer.chapter3;

public class 调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        Solution solution = new 调整数组顺序使奇数位于偶数前面().new Solution();
        solution.reOrderArrayWithoutChangeRelativeOrder(array);
        for (int anArray : array) {
            System.out.print(anArray);
        }
        System.out.println();

    }

    class Solution {
        // 不改变原来数组的相对顺序
        // 但是使用了辅助数组
        // T-C: O(N)
        // S-C: O(N)
        public void reOrderArrayWithoutChangeRelativeOrder(int[] array) {
            if (array == null || array.length <= 1) {
                return;
            }
            int[] temp = new int[array.length];
            int index = 0;
            for (int i = 0; i < array.length; i++) {
                if ((array[i] & 1) == 1) {
                    temp[index++] = array[i];
                }
            }

            for (int i = 0; i < array.length; i++) {
                if ((array[i] & 1) == 0) {
                    temp[index++] = array[i];
                }
            }

            for (int i = 0; i < array.length; i++) {
                array[i] = temp[i];
            }
        }

        // 相对顺序改变了
        // T-C: O(N)
        // S-C: O(1)
        public void reOrderArray(int [] array) {
            if (array == null || array.length <= 1) {
                return;
            }
            int start = 0;
            int end = array.length - 1;
            while (start < end) {
                while (start < end && (array[start] & 1) != 0) {
                    start++;
                }
                while (start < end && (array[start] & 1) == 0) {
                    end--;
                }
                if (start < end) {
                    swap(array, start, end);
                }
//            // 作用等同于下面的代码，但是下面的可能会多交换几次
//            if ((array[start] & 1) == 0) {
//                swap(array, start, end--);
//            } else {
//                start++;
//            }
            }
        }

        private void swap(int[] array, int index1, int index2) {
            array[index1] ^= array[index2];
            array[index2] ^= array[index1];
            array[index1] ^= array[index2];
        }
    }
}
