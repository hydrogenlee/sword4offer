package sword4offer.chapter2;

public class 斐波那契数列 {
    public static void main(String[] args) {
        Solution solution = new 斐波那契数列().new Solution();
        System.out.println(solution.fibonacci(10));     // 55
    }

    class Solution {
        public int fibonacciRecursive(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("输入参数有误");
            }
            if (n == 0 ) {
                return 0;
            }
            if (n == 1 ) {
                return 1;
            }

            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }

        public int fibonacci(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("输入参数有误");
            }
            if (n == 0 ) {
                return 0;
            }
            if (n == 1 ) {
                return 1;
            }

            int numberOne = 0;
            int numberTwo = 1;
            int result = 0;

            for (int i = 2; i <= n; i++) {
                result = numberOne + numberTwo;
                numberOne = numberTwo;
                numberTwo = result;
            }
            return result;
        }
    }
}
