package sword4offer.chapter5;

public class 丑数 {
    public static void main(String[] args) {
        System.out.println(getUglyNumber(1));           // 1
        System.out.println(getUglyNumber(2));           // 2
        System.out.println(getUglyNumber(3));           // 3
        System.out.println(getUglyNumber(4));           // 4
        System.out.println(getUglyNumber(5));           // 5
        System.out.println(getUglyNumber(1500));        // 859963392
    }

    // 把只包含因子2、3和5的数称作丑数（Ugly Number）， 1是第一个丑数
    private static int getUglyNumber(int index) {
        if (index <= 0) {
            throw new IllegalArgumentException("输入的参数有误");
        }

        int[] ugly = new int[index];
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int sequence2 = 1;
        int sequence3 = 1;
        int sequence5 = 1;
        for (int i = 0; i < index; i++) {
            ugly[i] = Math.min(Math.min(sequence2, sequence3), sequence5);      // 选取最小的值
            sequence2 = (sequence2 == ugly[i]) ? 2 * ugly[index2++] : sequence2;
            sequence3 = (sequence3 == ugly[i]) ? 3 * ugly[index3++] : sequence3;
            sequence5 = (sequence5 == ugly[i]) ? 5 * ugly[index5++] : sequence5;
        }
        return ugly[index - 1];
    }

    // 直接求解 超时了
    public static int getUglyNumberBruteForce(int index) {
        if (index <= 0) {
            throw new IllegalArgumentException("输入的参数有误");
        }

        int count = 1;
        int result = 1;
        int cur = 1;
        while (count <= index) {
            if (isUglyNumber(cur)) {
                result = cur;
                count++;
            }
            cur++;
        }
        return result;
    }

    private static boolean isUglyNumber(int num) {
        if (num < 1) {
            return false;
        }

        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }
}
