package sword4offer.chapter2;

public class 快速排序 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2, 0 , -1, 9, 33, 4, 4};
        quickQuick(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.printf(i + " ");
        }
    }

    public static void quickQuick(int[] arr, int start, int end){
        if (start >= end) {
            return;
        }

        int[] index = partition(arr, start, end);
        // 说明有小于区
        if (index[0] != start - 1) {
            quickQuick(arr, start, index[0]);
        }
        // 说明有大于区
        if (index[1] != end + 1) {
            quickQuick(arr, index[1], end);
        }

    }

    // 分成三部分，小于目标值，等于目标值，大于目标值
    // 返回的是等于区的左边界和右边界
    public static int[] partition(int[] arr, int start, int end) {
        int target = arr[start + (int)(Math.random() * (end - start + 1))];
        int smallIndex = start - 1;         // 第一个元素之前
        int bigIndex = end + 1;             // 最后一个元素之后
        int cur = start;
        while (cur < bigIndex) {
            if (arr[cur] == target) {
                cur++;
            } else if (arr[cur] < target) {
                swap(arr, ++smallIndex, cur++);
            } else {
                swap(arr, cur, --bigIndex);
            }
        }
        return new int[]{smallIndex, bigIndex};
    }

    public static void swap(int[] arr, int indexX, int indexY){
        int temp = arr[indexX];
        arr[indexX] = arr[indexY];
        arr[indexY] = temp;
    }
}
