package sword4offer.chapter3;

public class 打印1到最大的n位数 {
    public static void main(String[] args) {
        print1ToMaxOfNDigits(2);
        System.out.println("-----------------------------------------");
        print1ToMaxOfNDigitsUsingRecursive(2);
    }



    public static void print1ToMaxOfNDigitsUsingRecursive(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("输入参数不正确");
        }
        doRecursive(new char[n], 0);
    }

    private static void doRecursive(char[] array, int start) {
        if (start == array.length) {
            printNumber(array);
            return;
        }
        for (int i = 0; i < 10; i++) {
            array[start] = (char) (i + '0');
            doRecursive(array, start + 1);
        }
    }


    public static void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("输入参数不正确");
        }

        // 会出现int存不下的情况
        char[] array = new char[n];
        for (int i = 0; i < n; i++) {
            array[i] = '0';
        }

        while (!addOne(array)) {
            printNumber(array);
        }
    }

    private static boolean addOne(char[] array) {
        int i = array.length - 1;
        for (; i >= 0; i--) {
            if (array[i] == '9') {
                array[i] = '0';
            } else {
                array[i] += 1;
                break;
            }
        }
        return i == -1;
    }
    private static void printNumber(char[] array) {
        int i = 0;
        while (i < array.length && array[i] == '0') {
            i++;
        }
        if (i != array.length) {
            for (; i < array.length; i++) {
                System.out.printf(array[i] + "");
            }
            System.out.println();
        }
    }
}
