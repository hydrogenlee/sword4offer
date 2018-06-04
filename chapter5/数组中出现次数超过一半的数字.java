package sword4offer.chapter5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        System.out.println(getMoreThanHalfNumMethod1(new int[]{1, 2, 3, 2, 4, 2, 5, 2, 3}));       // 0
        System.out.println(getMoreThanHalfNumMethod1(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));       // 2
        System.out.println("--------------------------");
        System.out.println(getMoreThanHalfNumMethod2(new int[]{1, 2, 3, 2, 4, 2, 5, 2, 3}));       // 0
        System.out.println(getMoreThanHalfNumMethod2(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));       // 2
        System.out.println("--------------------------");
        System.out.println(getMoreThanHalfNumMethod3(new int[]{1, 2, 3, 2, 4, 2, 5, 2, 3}));       // 0
        System.out.println(getMoreThanHalfNumMethod3(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));       // 2
        System.out.println("--------------------------");
        System.out.println(getMoreThanHalfNumMethod4(new int[]{1, 2, 3, 2, 4, 2, 5, 2, 3}));       // 0
        System.out.println(getMoreThanHalfNumMethod4(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));       // 2
    }

    // 基于Partition函数的O(N)算法
    // T-C: O(N)
    // S-C: O(1)
    private static int getMoreThanHalfNumMethod1(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        int mid = array.length / 2;

        while (start < end) {
            int[] result = partition(array, start, end);
            if (result[0] < mid && mid < result[1]) {
                break;
            }
            if (result[0] > mid) {
                end = result[0];
            }
            if (result[1] < mid) {
                start = result[1];
            }
        }

        return check(array, array[array.length / 2]) ? array[array.length / 2] : 0;
    }


    private static int[] partition(int[] array, int start, int end) {
        if (array == null || array.length == 0 || start > end ||
                start < 0 || start >= array.length || end < 0 || end >= array.length) {
            throw new IllegalArgumentException("输入的参数有误");
        }

        int mid = array[(int) (Math.random() * (end - start + 1) + start)];
        int lessIndex = start - 1;
        int moreIndex = end + 1;
        int index = start;

        while (index < moreIndex) {
            if (array[index] == mid) {
                index++;
            } else if (array[index] < mid) {
                swap(array, index++, ++lessIndex);
            } else {
                swap(array, index, --moreIndex);
            }
        }
        return new int[]{lessIndex, moreIndex};
    }


    private static void swap(int[] array, int index1, int index2) {
        if (array == null || array.length == 0 || index1 < 0
                || index1 >= array.length || index2 < 0 || index2 >= array.length || index1 == index2) {
            return;
        }

        array[index1] ^= array[index2];
        array[index2] ^= array[index1];
        array[index1] ^= array[index2];
    }


    // 如果某数字的次数超过一半，那么该数字比其他所有的数字出现的次数的和还要多
    // 这种方法最好
    // T-C: O(N)
    // S-C: O(1)
    private static int getMoreThanHalfNumMethod2(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int target = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                // 指向下一个元素，并将次数置1
                target = array[i];
                times = 1;
                continue;
            }
            if (target != array[i]) {
                times--;
            } else {
                times++;
            }
        }

        return check(array, target) ? target : 0;

    }

    private static boolean check(int[] array, int target) {
        if (array == null || array.length == 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                count++;
            }
        }
        return count > array.length / 2;
    }
    // 使用辅助数组
    // T-C: O(N)
    // S-C: O(N)
    private static int getMoreThanHalfNumMethod3(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }

        int max = -1;
        int maxKey = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return max > (array.length / 2) ? maxKey : 0;
    }

    // 排序后查找
    // T-C: O(N*logN)
    // S-C: O(1)
    private static int getMoreThanHalfNumMethod4(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        Arrays.sort(array);
        // 检查是否存在超过一半的数字
        int target = array[array.length / 2];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                count++;
            } else if (array[i] > target) {
                break;
            }
        }
        // 超过，是大于，不是大于等于
        return count > (array.length / 2) ? target : 0;
    }
}
