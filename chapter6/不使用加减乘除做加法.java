package sword4offer.chapter6;

public class 不使用加减乘除做加法 {
    public static void main(String[] args) {
        System.out.println(add(1, 2));
    }

    // 不能用四则运算，只能用位运算了 & | ~ ^ << >>
    // 0 + 0 = 0, 1 + 0 = 1, 0 + 1 = 1 这是异或操作
    // 1 + 1 = 10，就是先异或后进位
    public static int add(int num1, int num2) {
        int sum;
        int carry;

        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);

        return num1;
    }
}
