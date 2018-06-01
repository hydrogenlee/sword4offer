package sword4offer.chapter2;

public class 斐波那契数列 {
    public static void main(String[] args) {
        System.out.println(fibonacciRecursive(10));     // 55
    }

    public static int fibonacciRecursive(int n) {
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

    public static int fibonacci(int n) {
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
