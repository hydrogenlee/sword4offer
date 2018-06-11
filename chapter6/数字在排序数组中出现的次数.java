package sword4offer.chapter6;

public class 数字在排序数组中出现的次数 {
    public static void main(String[] args) {
        Solution solution = new 数字在排序数组中出现的次数().new Solution();
        System.out.println(solution.getNumberOfKMethod1(new int[]{3}, 3));                          // 0
        System.out.println(solution.getNumberOfKMethod1(new int[]{3, 3, 3, 3, 4, 5}, 3));           // 4
        System.out.println(solution.getNumberOfKMethod1(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 3));     // 4
        System.out.println("----------------------");
        System.out.println(solution.getNumberOfKMethod2(new int[]{3}, 3));                          // 0
        System.out.println(solution.getNumberOfKMethod2(new int[]{3, 3, 3, 3, 4, 5}, 3));           // 4
        System.out.println(solution.getNumberOfKMethod2(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 3));     // 4
    }


    class Solution {
        // 使用二分查找
        // 需要找k第一次出现的位置和最后一次出现的位置，
        // 而不是当找到第一个k时，往两侧扩展
        public int getNumberOfKMethod1(int[] array, int k) {
            if (array == null || array.length == 0 || k < array[0] || k > array[array.length - 1]) {
                return 0;
            }

            // 二分查找第一个k的位置
            int result = 0;
            int firstK = getFirstK(array, k);
            // 如果查找第一个失败，那么直接返回，不需要查找最后一个k
            if (firstK != -1) {
                // 二分查找最后一个k的位置
                int lastK = getLastK(array, k);
                result = lastK - firstK + 1;
            }

            return result;
        }

        private int getFirstK(int[] array, int k) {
            if (array == null || array.length == 0 || k < array[0] || k > array[array.length - 1]) {
                return 0;
            }

            int start = 0;
            int end = array.length - 1;

            while (start <= end) {
                int mid = start + ((end - start) >> 1);
                if (array[mid] == k) {
                    if (mid == start || array[mid - 1] != k) {
                        return mid;
                    } else {
                        end = mid - 1;
                    }
                } else if (array[mid] < k) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            return -1;
        }


        private int getLastK(int[] array, int k) {
            if (array == null || array.length == 0 || k < array[0] || k > array[array.length - 1]) {
                return 0;
            }

            int start = 0;
            int end = array.length - 1;

            while (start <= end) {
                int mid = start + ((end - start) >> 1);
                if (array[mid] == k) {
                    if (mid == end || array[mid + 1] != k) {
                        return mid;
                    } else {
                        start = mid + 1;
                    }
                } else if (array[mid] < k) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            return -1;
        }


        // 使用二分查找的方法
        // 先找到一个k，然后再左右查找
        public int getNumberOfKMethod2(int[] array, int k) {
            if (array == null || array.length == 0 || k < array[0] || k > array[array.length - 1]) {
                return 0;
            }

            int start = 0;
            int end = array.length - 1;
            int times = 0;

            while (start <= end) {
                int mid = start + ((end - start) >> 1);
                if (array[mid] == k) {
                    // 往左查找
                    int index = mid;
                    times = 1; // mid的值
                    while (index > start && array[--index] == k) times++;
                    // 往右查找
                    index = mid;
                    while (index < end && array[++index] == k) times++;

                    break;

                } else if (array[mid] > k) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            return times;
        }
    }
}
