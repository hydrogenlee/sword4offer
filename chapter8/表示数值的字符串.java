package sword4offer.chapter8;

public class 表示数值的字符串 {
    public static void main(String[] args) {
        Solution solution = new 表示数值的字符串().new Solution();
        System.out.println(solution.isNumeric("+100".toCharArray()));            // true
        System.out.println(solution.isNumeric("5e2".toCharArray()));             // true
        System.out.println(solution.isNumeric("-123".toCharArray()));            // true
        System.out.println(solution.isNumeric("3.1416".toCharArray()));          // true
        System.out.println(solution.isNumeric("-1E-16".toCharArray()));          // true
        System.out.println(solution.isNumeric("1.23E2".toCharArray()));          // true
        System.out.println(solution.isNumeric("12e".toCharArray()));             // false
        System.out.println(solution.isNumeric("1a3.14".toCharArray()));          // false
        System.out.println(solution.isNumeric("1.2.3".toCharArray()));           // false
        System.out.println(solution.isNumeric("+-5".toCharArray()));             // false
        System.out.println(solution.isNumeric("12e+4.3".toCharArray()));         // false
    }

    class Solution {
        // 思路：
        // 正负号只能出现在0位置和e/E之后的位置
        // 只能有一个小数点，只能出现一个e/E
        // e/E之前之后都得有数值，E/e之前可以有小数点但是E之后不能有小数点
        public boolean isNumeric(char[] str) {
            if (str == null || str.length == 0) {
                return false;
            }

            // 首先判断E和e的位置
            if (str[0] == 'e' || str[0] == 'E' || str[str.length - 1] == 'e' || str[str.length - 1] == 'E') {
                return false;
            }

            boolean hasDot = false;
            boolean hasE = false;

            for (int i = 0; i < str.length; i++) {
                if (str[i] >= '0' && str[i] <= '9') {
                    // nothing to do
                } else if (str[i] == '+' || str[i] == '-') {
                    // '+'/'-'
                    if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E'){
                        return false;
                    }
                } else if (str[i] == '.') {
                    // '.' 当出现E/e之后，就不能出现小数点了
                    if (!hasDot && !hasE) {
                        hasDot = true;
                    } else {
                        return false;
                    }
                } else if (str[i] == 'e' || str[i] == 'E') {
                    // 'e'/'E'
                    if (!hasE) {
                        hasE = true;
                    } else {
                        return false;
                    }
                } else {
                    // 其他非法字符
                    return false;
                }
            }
            return true;
        }
    }
}
