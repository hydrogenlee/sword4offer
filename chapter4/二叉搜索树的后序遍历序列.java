package sword4offer.chapter4;

// 注意：树是二叉搜索树

public class 二叉搜索树的后序遍历序列 {
    public static void main(String[] args) {
        Solution solution = new 二叉搜索树的后序遍历序列().new Solution();
        System.out.println(solution.verifySequenceOfBAST(new int[]{5, 7, 6, 9, 11, 10, 8}));   // true
        System.out.println(solution.verifySequenceOfBAST(new int[]{7, 4, 6, 5}));              // false
    }

    class Solution {
        public boolean verifySequenceOfBAST(int [] sequence) {
            if (sequence == null || sequence.length <= 0) {
                return false;
            }

            return doVerify(sequence, 0, sequence.length - 1);
        }

        private boolean doVerify(int[] sequence, int start, int end) {
            if (start >= end) {
                return true;
            }

            // 找到第一个大于sequence[end]的位置
            int mid = start;
            for (int i = start; i < end; i++) {
                if (sequence[i] < sequence[end]) {
                    mid = i;
                } else {
                    break;
                }
            }

            // 检查后半部分是否符合要求
            for (int i = mid + 1; i < end - 1; i++) {
                if (sequence[i] < sequence[end]) {
                    return false;
                }
            }

            return doVerify(sequence, start, mid) && doVerify(sequence, mid + 1, end - 1);
        }
    }
}
