package sword4offer.chapter8;

public class 矩阵中的路径 {
    public static void main(String[] args) {
        Solution solution = new 矩阵中的路径().new Solution();
        char[] matrix = new char[]{ 'a', 'b', 'c', 'e',
                                    's', 'f', 'c', 's',
                                    'a', 'd', 'e', 'e'};
        System.out.println(solution.hasPath(matrix, 3, 4, new char[]{'b', 'c', 'c', 'e', 'd'}));     // true
        System.out.println(solution.hasPath(matrix, 3, 4, new char[]{'a', 'b', 'c', 'b'}));          // false
        System.out.println(solution.hasPath(new char[]{'a'}, 1, 1, new char[]{'a'}));                // true
    }

    class Solution {
        // 回溯法
        public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
            if (matrix == null || matrix.length == 0 || str == null || str.length == 0 ||
                    rows <= 0 || cols <= 0 || rows * cols != matrix.length) {
                return false;
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    boolean[] visited = new boolean[matrix.length];
                    if (findPath(matrix, rows, cols, str, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean findPath(char[] matrix, int rows, int cols, char[] str, int curRow, int curCol, int index, boolean[] visited) {
            // 如果到达最后一个了，说明全部匹配完成
            if (index == str.length) {
                return true;
            }
            // 参数是否符合要求
            if (curRow < 0 || curRow >= rows || curCol < 0 || curCol >= cols) {
                return false;
            }
            int cur = curRow * cols + curCol;
            if (cur >= matrix.length || visited[cur] || matrix[cur] != str[index]) {
                return false;
            }
            visited[cur] = true;
            boolean result = findPath(matrix, rows, cols, str, curRow, curCol - 1, index + 1, visited) ||         // 往左走
                             findPath(matrix, rows, cols, str, curRow, curCol + 1, index + 1, visited) ||         // 往右走
                             findPath(matrix, rows, cols, str, curRow - 1, curCol, index + 1, visited) ||        // 往上走
                             findPath(matrix, rows, cols, str, curRow + 1, curCol, index + 1, visited);          // 往下走
            // 如果匹配失败，将当前位置置为未访问状态
            if (!result) {
                visited[cur] = false;
            }
            return result;
        }
    }
}