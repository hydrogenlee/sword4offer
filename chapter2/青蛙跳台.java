package sword4offer.chapter2;

public class 青蛙跳台 {
    public static void main(String[] args) {
        Solution solution = new 青蛙跳台().new Solution();
        System.out.println(solution.jumpFloor(10));  // 89
    }

    class Solution {
        public int jumpFloor(int target) {
            if (target <= 0) {
                throw new IllegalArgumentException("参数错误");
            }

            if (target == 1) {
                return 1;
            }

            int beforeTwoStep = 1;
            int beforeOneStep = 1;
            int result = 0;

            for (int i = 2; i <= target; i++) {
                result = beforeOneStep + beforeTwoStep;
                beforeTwoStep = beforeOneStep;
                beforeOneStep = result;
            }

            return result;
        }
    }
}
