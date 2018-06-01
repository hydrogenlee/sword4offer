package sword4offer.chapter2;

public class 二进制中1的个数 {
    public static void main(String[] args) {
        System.out.println(numberOf1Method1(9));                   // 01001 -> 2
        System.out.println(numberOf1Method1(-9));                  // 31
        System.out.println(numberOf1Method1(0));                   // 00000 -> 0
        System.out.println(numberOf1Method1(Integer.MAX_VALUE));      // 31
        System.out.println(numberOf1Method1(Integer.MIN_VALUE));      // 1
        System.out.println(numberOf1Method1(-1));                  // 32
        System.out.println("---------------------------");
        System.out.println(numberOf1Method2(9));                   // 01001 -> 2
        System.out.println(numberOf1Method2(-9));                  // 31
        System.out.println(numberOf1Method2(0));                   // 00000 -> 0
        System.out.println(numberOf1Method2(Integer.MAX_VALUE));      // 31
        System.out.println(numberOf1Method2(Integer.MIN_VALUE));      // 1
        System.out.println(numberOf1Method2(-1));                  // 32
        System.out.println("---------------------------");
        System.out.println(numberOf1Method3(9));                   // 01001 -> 2
        System.out.println(numberOf1Method3(-9));                  // 31
        System.out.println(numberOf1Method3(0));                   // 00000 -> 0
        System.out.println(numberOf1Method3(Integer.MAX_VALUE));      // 31
        System.out.println(numberOf1Method3(Integer.MIN_VALUE));      // 1
        System.out.println(numberOf1Method3(-1));                  // 32

    }

    public static int numberOf1Method1(int n) {
        int count = 0;
        int time = 0;
        while (n != 0 && time++ != 32) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    public static int numberOf1Method2(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag <<= 1;
        }
        return count;
    }

    public static int numberOf1Method3(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }
}
