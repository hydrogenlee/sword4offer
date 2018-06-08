package sword4offer.chapter6;

public class 求1连加到n {
    public static void main(String[] args) {
        System.out.println(getSum(10));
        System.out.println(getSum1(10));
    }

    // 不使用乘除法，for,while,if,else,switch, case等关键字及条件判断语句
    private static int getSum(int n) {
        boolean temp = (n != 0 && (n += getSum(n - 1)) != 0);
        return n;
    }

    //使用公式的算法
    private static int getSum1(int n) {
        if (n < 0) {
            return 0;
        }
        return (n * (n + 1)) / 2;
    }
}
