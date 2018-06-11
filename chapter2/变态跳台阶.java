package sword4offer.chapter2;

public class 变态跳台阶 {
    public static void main(String[] args) {
        Solution solution = new 变态跳台阶().new Solution();
        System.out.println(solution.jumpFloorII(10));            // 512
    }

    class Solution {
        public int jumpFloorII(int target) {
            if (target <= 0) {
                throw new IllegalArgumentException("参数错误");
            }
            return (int)Math.pow(2, target - 1);
        }
    }
}
