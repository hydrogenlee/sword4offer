package sword4offer.chapter8;

public class 构建乘积数组 {
    public static void main(String[] args) {
        int[] result = multiplyUsingConstantSpace(new int[]{1, 2, 3, 4, 5});
        for (int i : result) {
            System.out.printf(i + " ");
        }
        System.out.println();
    }

    // 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
    // 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。 缺失A[i]
    // 不能使用除法。
    // T-C: O(N)
    // S-C: O(1)
    public static int[] multiplyUsingConstantSpace(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }

        int[] result = new int[A.length];
        int temp = 1;
        for (int i = 0; i < result.length; i++) {
            result[i] = temp;
            temp *= A[i];
        }

        temp = 1;
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = result[i] * temp;
            temp *= A[i];
        }
        return result;
    }

    // T-C: O(N)
    // S-C: O(N)
    public static int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        // 如果只有一个元素，那么返回1
        if (A.length == 1) {
            return new int[]{1};
        }
        // 使用正反两个辅助数组
        int[] leftToRight = new int[A.length - 1];
        int[] rightToLeft = new int[A.length - 1];
        leftToRight[0] = A[0];
        rightToLeft[rightToLeft.length - 1] = A[A.length - 1];

        for (int i = 1; i < leftToRight.length; i++) {
            leftToRight[i] = leftToRight[i - 1] * A[i];
        }
        for (int i = rightToLeft.length - 2; i >= 0; i--) {
            rightToLeft[i] = rightToLeft[i + 1] * A[i + 1];
        }

        int[] result = new int[A.length];
        result[0] = rightToLeft[0];
        result[result.length - 1] = leftToRight[leftToRight.length - 1];
        for (int i = 1; i < result.length - 1; i++) {
            result[i] = leftToRight[i - 1] * rightToLeft[i];
        }

        return result;
    }
}
