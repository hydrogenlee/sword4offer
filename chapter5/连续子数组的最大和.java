package sword4offer.chapter5;

public class 连续子数组的最大和 {
    public static void main(String[] args) {
        Solution solution = new 连续子数组的最大和().new Solution();
        System.out.println(solution.findGreatestSumOfSubArray(new int[]{6, -3, -2, 7, -15, 1, 2, 2}));   // 8
        System.out.println(solution.findGreatestSumOfSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5}));   // 18
    }

    class Solution {
        // 思路：如果之前的和加上当前值小于当前值，则抛弃之前的值，反之加上当前值
        // T-C: O(N)
        // S-C: O(1)
        public int findGreatestSumOfSubArray(int[] array) {
            if (array == null || array.length == 0) {
                return 0;
            }

            int max = Integer.MIN_VALUE;
            int temp = 0;
            for (int i = 0; i < array.length; i++) {
                if (temp  < 0) {
                    temp = array[i];
                } else {
                    temp += array[i];
                }
                max = Math.max(max, temp);
            }
            return max;
        }
    }
}
