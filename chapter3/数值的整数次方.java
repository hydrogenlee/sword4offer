package sword4offer.chapter3;

public class 数值的整数次方 {
    public static void main(String[] args) {
        System.out.println(power(2, 4));
        System.out.println(quickPower(2, 4));
        System.out.println(quickPower(2, 5));
    }

    public static double power(double base, int exponent) {
        // 由于计算机表示小数时，都有误差，所有不能用==判断小数是否相等
        if (Math.abs(base - 0) < 0.0000001) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        double result = 1.0;
        if (exponent < 0) {
            exponent = -exponent;
            base = 1 / base;
        }
        for (int  i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static double quickPower(double base, int exponent) {
        if (Math.abs(base - 0) < 0.0000001) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        int signum = 1;
        if (exponent < 0) {
            exponent = -exponent;
            signum = -1;
        }
        double result = 1.0;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result *= base;
            }
            base *= base;
            exponent >>= 1;
        }

        return signum != -1 ? result : 1 / result;
    }
}
