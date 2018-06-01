package sword4offer.chpater4;

import java.util.ArrayList;

public class 顺时针打印矩阵 {
    public static void main(String[] args) {
        ArrayList<Integer> result = printMatrix(new int[][]{
                { 1,  2,  3,  4},
                { 5,  6,  7,  8},
                { 9, 10, 11, 12},
                {13, 14, 15, 16}
        });
        // 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
        for (int i = 0; i < result.size(); i++) {
            System.out.printf(result.get(i) + " ");
        }
        System.out.println();

        result = printMatrix(new int[][]{
                { 1,  2,  3},
                { 4,  5,  6},
                { 7,  8,  9},
                {10, 11, 12}
        });
        // 1 2 3 6 9 12 11 10 7 4 5 8
        for (int i = 0; i < result.size(); i++) {
            System.out.printf(result.get(i) + " ");
        }
        System.out.println();

        result = printMatrix(new int[][]{{1}});
        // 1
        for (int i = 0; i < result.size(); i++) {
            System.out.printf(result.get(i) + " ");
        }
        System.out.println();

        result = printMatrix(new int[][]{{1},{2},{3},{4},{5}});
        // 1 2 3 4 5
        for (int i = 0; i < result.size(); i++) {
            System.out.printf(result.get(i) + " ");
        }
        System.out.println();
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();

        int leftCornerRow = 0;
        int leftCornerCol = 0;
        int rightCornerRow = matrix.length - 1;
        int rightCornerCol = matrix[0].length - 1;

        while (leftCornerRow <= rightCornerRow && leftCornerCol <= rightCornerCol) {
            // 只剩下一行
            if (leftCornerRow == rightCornerRow) {
                for (int i = leftCornerCol; i <= rightCornerCol; i++) {
                    result.add(matrix[leftCornerRow][i]);
                }
                break;
            }

            // 只剩下一列
            if (leftCornerCol == rightCornerCol) {
                for (int i = leftCornerRow; i <= rightCornerRow; i++) {
                    result.add(matrix[i][leftCornerCol]);
                }
                break;
            }

            // 打印上面的几个
            for (int i = leftCornerCol; i < rightCornerCol; i++) {
                result.add(matrix[leftCornerRow][i]);
            }
            // 打印右边的几个
            for (int i = leftCornerRow; i < rightCornerRow; i++) {
                result.add(matrix[i][rightCornerCol]);
            }
            // 打印下面的几个
            for (int i = rightCornerCol; i > leftCornerCol; i--) {
                result.add(matrix[rightCornerRow][i]);
            }

            // 打印左边的几个
            for (int i = rightCornerRow; i > leftCornerRow ; i--) {
                result.add(matrix[i][leftCornerCol]);
            }

            leftCornerRow++;
            leftCornerCol++;
            rightCornerRow--;
            rightCornerCol--;
        }
        return result;
    }

    public static ArrayList<Integer> printMatrixRecursive(int [][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();

        doRecursive(matrix, result, 0, 0,
                matrix.length - 1, matrix[0].length - 1);

        return result;
    }

    private static void doRecursive(int[][] matrix, ArrayList<Integer> result,
                                    int leftCornerRow, int leftCornerCol,
                                    int rightCornerRow, int rightCornerCol) {
        if (leftCornerRow > rightCornerRow || leftCornerCol > rightCornerCol) {
            return;
        }
        // 只剩下一行
        if (leftCornerRow == rightCornerRow) {
            for (int i = leftCornerCol; i <= rightCornerCol; i++) {
                result.add(matrix[leftCornerRow][i]);
            }
            return;
        }

        // 只剩下一列
        if (leftCornerCol == rightCornerCol) {
            for (int i = leftCornerRow; i <= rightCornerRow; i++) {
                result.add(matrix[i][leftCornerCol]);
            }
            return;
        }

        // 打印上面的几个
        for (int i = leftCornerCol; i < rightCornerCol; i++) {
            result.add(matrix[leftCornerRow][i]);
        }
        // 打印右边的几个
        for (int i = leftCornerRow; i < rightCornerRow; i++) {
            result.add(matrix[i][rightCornerCol]);
        }
        // 打印下面的几个
        for (int i = rightCornerCol; i > leftCornerCol; i--) {
            result.add(matrix[rightCornerRow][i]);
        }
        // 打印左边的几个
        for (int i = rightCornerRow; i > leftCornerRow ; i--) {
            result.add(matrix[i][leftCornerCol]);
        }

        doRecursive(matrix, result, ++leftCornerRow,
                ++leftCornerCol, --rightCornerRow, --rightCornerCol);
    }
}
