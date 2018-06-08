package sword4offer.chapter6;

public class 不使用新的变量交换两个变量的值 {

    private static void swapUsingXOR(int[] array, int index1, int index2) {
        if (array == null || array.length == 0 || index1 < 0 || index1 >= array.length ||
                index2 < 0 || index2 >= array.length || index1 == index2) {
            return;
        }

        array[index1] ^= array[index2];
        array[index2] ^= array[index1];
        array[index1] ^= array[index2];
    }

    private static void swapUsingAddAndSub(int[] array, int index1, int index2) {
        if (array == null || array.length == 0 || index1 < 0 || index1 >= array.length ||
                index2 < 0 || index2 >= array.length || index1 == index2) {
            return;
        }

        array[index1] = array[index1] + array[index2];
        array[index2] = array[index1] - array[index2];
        array[index1] = array[index1] - array[index2];
    }
}
