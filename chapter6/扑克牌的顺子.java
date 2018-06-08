package sword4offer.chapter6;

import java.util.Arrays;

public class 扑克牌的顺子 {
    public static void main(String[] args) {
        System.out.println(isContinuous(new int[]{0, 1, 4, 5, 3}));             // true
        System.out.println(isContinuous(new int[]{0, 1, 4, 6, 3}));             // false
        System.out.println(isContinuous(new int[]{0, 1, 3, 4, 3}));             // false
        System.out.println(isContinuous(new int[]{5, 1, 2, 4, 3}));             // true
        System.out.println(isContinuous(new int[]{1, 3, 4, 5, 6}));             // false
    }

    // 假设大小王为0
    public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }

        if (numbers.length == 1) {
            return true;
        }

        Arrays.sort(numbers);

        int zeroNum;
        int nonZeroIndex = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                nonZeroIndex++;
            }else {
                break;
            }
        }
        zeroNum = nonZeroIndex;

        for (int i = nonZeroIndex; i < numbers.length - 1; i++) {
            // 如果出现重复肯定不是顺子
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            zeroNum -= numbers[i + 1] - numbers[i] - 1;
            if (zeroNum < 0) {
                return false;
            }
        }
        return true;
    }
}
