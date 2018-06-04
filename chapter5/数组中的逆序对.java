package sword4offer.chapter5;

public class 数组中的逆序对 {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        System.out.println(inversePairs(new int[]{7, 5, 6, 4}));                // 5
        System.out.println(inversePairs(new int[]{1, 2, 3, 4, 5, 6, 7, 0}));    // 7
    }

    // 思路：使用归并排序的思路
    // 当前面一个数组的值大于后面数组的值时，存在逆序对，逆序对的个数为第二个子数组中剩余的数字的个数
    // 当前面一个数组的值小于等于后面数组的值时，则不存在逆序对
    private static int inversePairs(int [] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }

        return (int) mergeSort(array, 0, array.length - 1);
    }

    private static long mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int mid = start + ((end - start) >> 1);
        long leftCount = mergeSort(array, start, mid);
        long rightCount = mergeSort(array, mid + 1, end);

        return (leftCount % MOD + rightCount % MOD + merge(array, start, end)) % MOD;
    }

    private static long merge(int[] array, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int[] helper = new int[end - start + 1];
        int mid = start + ((end - start) >> 1);
        int leftLastIndex = mid;
        int rightLastIndex = end;
        int index = helper.length - 1;
        long count = 0;                  // 统计逆序对的个数

        while (leftLastIndex >= start && rightLastIndex >= mid + 1) {
            if (array[leftLastIndex] > array[rightLastIndex]) {
                // 此时统计逆序对的个数
                count += rightLastIndex - mid;
                helper[index--] = array[leftLastIndex--];
            } else {
                helper[index--] = array[rightLastIndex--];
            }
        }

        while (leftLastIndex >= start) {
            helper[index--] = array[leftLastIndex--];
        }

        while (rightLastIndex >= mid + 1) {
            helper[index--] = array[rightLastIndex--];
        }
        // 复制回原数组
        for (int i = 0; i < helper.length; i++) {
            array[start + i] = helper[i];
        }

        return count % MOD;
    }
}
