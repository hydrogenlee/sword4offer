package sword4offer.chapter4;

// 注意：树是二叉搜索树

public class 二叉搜索树的后序遍历序列 {
    public static void main(String[] args) {
        System.out.println(verifySequenceOfBAST(new int[]{5, 7, 6, 9, 11, 10, 8}));   // true
        System.out.println(verifySequenceOfBAST(new int[]{7, 4, 6, 5}));              // false
    }

    public static boolean verifySequenceOfBAST(int [] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }

        return doVerify(sequence, 0, sequence.length - 1);
    }

    private static boolean doVerify(int[] sequence, int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException("参数输入不正确");
        }
        // 检查左子树
        int i = start;
        for (; i < end; i++) {
            if (sequence[i] > sequence[end]) {
                break;
            }
        }
        // 检查右子树
        int mid = i;
        for (; i < end; i++) {
            if (sequence[i] < sequence[end]) {
                break;
            }
        }
        if (i != end) {
            return false;
        }
        boolean verifyLeft = true;
        boolean verifyRight = true;
        if (start < mid - 1) {
            verifyLeft = doVerify(sequence, start, mid - 1);
        }
        if (mid < end - 1) {
            verifyRight = doVerify(sequence, mid, end - 1);
        }
        return verifyLeft && verifyRight;
    }
}
