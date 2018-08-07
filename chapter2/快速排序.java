package sword4offer.chapter2;

import java.util.Stack;

public class 快速排序 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2, 0, -1, 9, 33, 4, 4};
        Solution solution = new 快速排序().new Solution();
        solution.quickSortWithoutRecursive(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    class Solution {

        // 使用栈
        // 非递归快速排序
        public void quickSortWithoutRecursive(int[] arr, int start, int end) {
            if (start >= end) {
                return;
            }
            Stack<Integer> stack = new Stack<>();
            stack.push(start);
            stack.push(end);

            while (!stack.isEmpty()) {
                int right = stack.pop();
                int left = stack.pop();
                if (left < right) {
                    int[] index = partition(arr, left, right);
                    // 左边
                    stack.push(left);
                    stack.push(index[0]);
                    // 右边
                    stack.push(index[1]);
                    stack.push(right);
                }
            }
        }

        // 挖坑法
        public void quickSortWithHole(int[] arr, int start, int end) {
            if (start >= end) {
                return;
            }
            int mid = arr[end];
            int left = start;
            int right = end;
            while (left < right) {
                // 从左边找一个
                while (left < right && arr[left] <= mid) {
                    left++;
                }
                // 填右边的坑
                if (left < right) {
                    arr[right] = arr[left];
                }
                // 从右边找一个
                while (left < right && arr[right] >= mid) {
                    right--;
                }
                // 填左边的坑
                if (left < right) {
                    arr[left] = arr[right];
                }
            }

            arr[left] = mid;
            quickSortWithHole(arr, start, left - 1);
            quickSortWithHole(arr, right + 1, end);
        }

        // 前后指针法
        public void quickSortWithTwoPointer(int[] arr, int start, int end) {
            if (start >= end) {
                return;
            }
            int left = start;
            int right = end;
            int mid = arr[right];
            while (left < right) {
                while (left < right && arr[left] <= mid) {
                    left++;
                }
                while (left < right && arr[right] >= mid) {
                    right--;
                }

                if (left < right) {
                    swap(arr, left, right);
                }
            }
            swap(arr, left, end);
            quickSortWithTwoPointer(arr, start, left - 1);
            quickSortWithTwoPointer(arr, left + 1, end);
        }

        public void quickSortUsingPartition(int[] arr, int start, int end){
            if (start >= end) {
                return;
            }

            int[] index = partition(arr, start, end);
            quickSortUsingPartition(arr, start, index[0]);
            quickSortUsingPartition(arr, index[1], end);

        }

        // 分成三部分，小于目标值，等于目标值，大于目标值
        // 返回的是等于区的左边界和右边界
        private int[] partition(int[] arr, int start, int end) {
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

        private void swap(int[] arr, int indexX, int indexY){
            int temp = arr[indexX];
            arr[indexX] = arr[indexY];
            arr[indexY] = temp;
        }
    }
}
