package sword4offer.chapter7;

public class 把字符串转换为整数 {
    public static void main(String[] args) {
        System.out.println("\"\":\t"              + strToInt2(""));                   // 0
        System.out.println("\"0\":\t"             + strToInt2("0"));                  // 0
        System.out.println("\"2e3\":\t"           + strToInt2("2e3"));                // 0
        System.out.println("\"134\":\t"           + strToInt2("134"));                // 134
        System.out.println("\"+134\":\t"          + strToInt2("+134"));               // 134
        System.out.println("\"-134\":\t"          + strToInt2("-134"));               // -134
        System.out.println("\"123.34\":\t"        + strToInt2("123.34"));             // 0
        System.out.println("\" -1123\":\t"        + strToInt2(" -1123"));             // 0
        System.out.println("\"    +1234\":\t"     + strToInt2("    +1234"));          // 0
        System.out.println("\"12434adae2\":\t"    + strToInt2("12434adae2"));         // 0
        System.out.println("\"2147483647\":\t"    + strToInt2("2147483647"));         // 2147483647
        System.out.println("\"2147483648\":\t"    + strToInt2("2147483648"));         // 0
        System.out.println("\"-2147483648\":\t"   + strToInt2("-2147483648"));        // -2147483648
        System.out.println("\"-2147483649\":\t"   + strToInt2("-2147483649"));        // 0
    }

    public static int strToInt(String str) {
        if (str == null || str.length() == 0) {
            //throw new NumberFormatException(str);
            return 0;
        }

        int index = 0;
        int sigNum = 1;
        char[] numChar = str.toCharArray();
        if (numChar[0] == '+' || numChar[0] == '-') {
            sigNum = numChar[0] == '+' ? 1 : -1;
            index++;
        }
        int result = 0;

        while (index < numChar.length && numChar[index] >= '0' && numChar[index] <= '9') {
            int temp = numChar[index] - '0';
            if (result < Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && temp <= Integer.MAX_VALUE % 10 + 1)) {
                // 检查是不是下界
                index++;
                if (result == Integer.MAX_VALUE / 10 && temp == Integer.MAX_VALUE % 10 + 1) {
                    result = sigNum == -1 ? Integer.MIN_VALUE : 0;
                    break;
                }
                result = result * 10 + temp;

            } else {
                break;
            }
        }

//        if (index != numChar.length) {
//            throw new NumberFormatException(str);
//        }

        result = (result == Integer.MIN_VALUE) ? result : result * sigNum;
        return index == numChar.length ? result : 0;
    }

    // 直接用long来保结果，然后最后进行判断
    public static int strToInt2(String str) {
        if (str == null || str.length() == 0) {
            //throw new NumberFormatException(str);
            return 0;
        }

        int index = 0;
        int sigNum = 1;
        char[] numChar = str.toCharArray();
        if (numChar[0] == '+' || numChar[0] == '-') {
            sigNum = numChar[0] == '+' ? 1 : -1;
            index++;
        }
        long result = 0L;

        while (index < numChar.length && numChar[index] >= '0' && numChar[index] <= '9') {
            result = result * 10 + numChar[index] - '0';
            if ((sigNum == 1 && result > Integer.MAX_VALUE) || (sigNum == -1 && result - 1 > Integer.MAX_VALUE)) {
                break;
            }
            index++;
        }
        if (index != numChar.length) {
            // throw new NumberFormatException(str);
            return 0;
        }

        return (int) (result * sigNum);
    }
}
