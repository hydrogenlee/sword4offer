package sword4offer.chapter2;

public class 矩形覆盖 {
    public static void main(String[] args) {
        Solution solution = new 矩形覆盖().new Solution();
        System.out.println(solution.rectCover(10));      // 89
    }

    class Solution {
        public int rectCover(int target) {
            if (target < 0) {
                throw new IllegalArgumentException("参数输入错误");
            }

            if (target == 0) {
                return 0;
            }

            if (target == 1) {
                return 1;
            }

            int coverBeforeOne = 1;
            int coverBeforeTwo = 1;
            int result = 0;

            for (int i = 2; i <= target; i++) {
                result = coverBeforeOne + coverBeforeTwo;
                coverBeforeTwo = coverBeforeOne;
                coverBeforeOne = result;
            }

            return result;
        }
    }
}
