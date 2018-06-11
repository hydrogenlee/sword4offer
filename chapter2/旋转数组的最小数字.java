package sword4offer.chapter2;

public class 旋转数组的最小数字 {
    public static void main(String[] args) {
        Solution solution = new 旋转数组的最小数字().new Solution();
        System.out.println(solution.minNumberInRotateArray2(new int[]{3, 4, 5, 1, 2, 3}));
        System.out.println(solution.minNumberInRotateArray2(
                new int[]{2, 2, 2, 2, 2}));
    }

    class Solution {
        public int minNumberInRotateArray2(int [] array) {
            if (array == null || array.length == 0) {
                return 0;
            }
            if (array[0] < array[array.length - 1]) {
                // 没有进行翻转
                return array[0];
            }
            int start = 0 ;
            int end = array.length - 1;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (array[mid] > array[end]) {
                    start = mid + 1;
                } else if (array[mid] == array[end]) {
                    end = end - 1;      // 顺序查找
                } else {
                    end = mid;          // 注意，这个地方不是mid - 1，因为最小值可能在mid位置上
                }
            }
            return array[start];
        }

        public int minNumberInRotateArray(int [] array) {
            if (array == null || array.length == 0) {
                return 0;
            }
            if (array[0] < array[array.length - 1]) {
                // 没有进行翻转
                return array[0];
            }
            int start = 0;
            int end = array.length - 1;
            int mid = start;        // 如果是有序的，直接返回
            while (array[start] >= array[end]) {
                if (end - start == 1) {
                    mid = end;
                    break;
                }
                mid = (end - start) / 2 + start;

                if (array[start] == array[mid] && array[mid] == array[end]) {
                    // 此时只能顺序查找
                    return minInOrder(array, start, end);
                }

                if (array[mid] >= array[start]) {
                    start = mid;
                } else if (array[mid] <= array[end]) {
                    end = mid;
                }
            }
            return array[mid];
        }

        private int minInOrder(int[] array, int start, int end) {
            int result = array[start];          // 判断如果都相等的情况
            for (int i = start; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    result = array[i + 1];
                }
            }
            return result;
        }
    }
}
