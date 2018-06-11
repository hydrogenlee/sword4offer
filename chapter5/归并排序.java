package sword4offer.chapter5;

public class 归并排序 {
    public static void main(String[] args) {
        int[] array = new int[]{7, 5, 6, 4};
        System.out.println("排序之前：");
        for (int i = 0; i < array.length; i++) {
            System.out.printf(array[i] + " ");
        }
        System.out.println();
        Solution solution = new 归并排序().new Solution();
        solution.mergeSort(array);
        System.out.println("排序之后：");
        for (int i = 0; i < array.length; i++) {
            System.out.printf(array[i] + " ");
        }
        System.out.println();
    }
    class Solution {
        public void mergeSort(int[] array) {
            if (array == null || array.length <= 1) {
                return;
            }

            mergeProcess(array, 0, array.length - 1);
        }

        private void mergeProcess(int[] array, int start, int end) {
            if (start >= end) {
                return;
            }

            int mid = start + ((end - start) >> 1);
            mergeProcess(array, start, mid);
            mergeProcess(array, mid + 1, end);
            merge(array, start, end);
        }

        private void merge(int[] array, int start, int end) {
            int[] helper = new int[end - start + 1];
            int mid = start + ((end - start) >> 1);
            int leftIndex = start;
            int rightIndex = mid + 1;
            int index = 0;
            while (leftIndex <= mid && rightIndex <= end) {
                helper[index++] = array[leftIndex] < array[rightIndex] ? array[leftIndex++] : array[rightIndex++];
            }

            while (leftIndex <= mid) {
                helper[index++] = array[leftIndex++];
            }

            while (rightIndex <= end) {
                helper[index++] = array[rightIndex++];
            }

            for (int i = 0; i < helper.length; i++) {
                array[start + i] = helper[i];
            }
        }
    }
}
