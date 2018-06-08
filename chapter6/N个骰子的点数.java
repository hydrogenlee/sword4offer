package sword4offer.chapter6;

public class N个骰子的点数 {
    private static final int MAX_VALUE = 6;
    public static void main(String[] args) {
        System.out.println("------------递归-------------");
        System.out.println(calculateProbability(1, 4));   // 0.166666667
        System.out.println(calculateProbability(2, 12));  // 0.0277777776
        System.out.println(calculateProbability(3, 15));  // 0.0462962963
        System.out.println(calculateProbability(10, 32)); // 0.06287043851
        System.out.println("-------------DP--------------");
        System.out.println(calculateProbabilityUsingDP(1, 4));   // 0.166666667
        System.out.println(calculateProbabilityUsingDP(2, 12));  // 0.0277777776
        System.out.println(calculateProbabilityUsingDP(3, 15));  // 0.0462962963
        System.out.println(calculateProbabilityUsingDP(10, 32)); // 0.06287043851
    }


    // 使用动态规划的思想
    // 状态转移方程
    // 有意义的参数： n >= 1 && s >= n && s <= 6 * n
    // f(n, s) = f(n-1, s-1) + f(n-1, s-2) + f(n-1, s-3) + f(n-1, s-4), f(n-1, s-5) + f(n-1, s-6)
    // f(1, 1) = 1; f(1, 2) = 1; f(1, 3) = 1; f(1, 4) = 1; f(1, 5) = 1; f(1, 6) = 1;
    private static double calculateProbabilityUsingDP(int n, int s) {
        if (n <= 0 || s < n || n * MAX_VALUE < s) {
            return 0.0;
        }

        int[][] matrix = new int[n + 1][s + 1];
        // 初始化只有一个骰子的情况
        for (int i = 1; i <= MAX_VALUE && i <= s; i++) {        // 防止s小于6时出错
            matrix[1][i] = 1;
        }
        if (n > 1) {
            for (int i = 2; i < matrix.length; i++) {
                for (int j = i; j <= i * MAX_VALUE && j < matrix[0].length; j++) {
                    // 一共执行6次
                    // f(n, s) = f(n-1, s-1) + f(n-1, s-2) + f(n-1, s-3) + f(n-1, s-4), f(n-1, s-5) + f(n-1, s-6)
                    int count = 0;
                    for (int k = 1; k <= 6 && j - k >= 1; k++) {
                        count += matrix[i - 1][j - k];
                    }
                    matrix[i][j] = count;
                }
            }
        }


        // 打印dp数组
        System.out.println("--------------------------------");
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                System.out.printf("%7d ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------------");

        int totalTimes = (int) Math.pow(MAX_VALUE, n);
        System.out.printf("%d/%d\n", matrix[n][s], totalTimes);
        return (double) matrix[n][s] / totalTimes;
    }


    // 使用递归的方法
    private static double calculateProbability(int n, int s) {
        if (n <= 0 || s < n || n * MAX_VALUE < s) {
            return 0.0;
        }
        long count = getCount(n, s);
        long totalTimes = (long) Math.pow(MAX_VALUE, n);
        System.out.printf("%d/%d\n", count, totalTimes);
        return (double) count / totalTimes;
    }

    private static long getCount(int n, int s) {
        if (n < 0 || s < n || n * MAX_VALUE < s) {
            return 0L;
        }
        if (n == 1) {
            return 1L;
        }

        long count = 0L;
        for (int i = 1; i <= MAX_VALUE; i++) {
            count += getCount(n - 1, s - i);
        }

        return count;
    }
}
