package sword4offer.chapter8;

public class 机器人的运动轨迹 {
    public static void main(String[] args) {
        Solution solution = new 机器人的运动轨迹().new Solution();
        System.out.println(solution.movingCount(5, 4, 4));  // 15
        System.out.println(solution.movingCount(4, 4, 4));  // 13
    }

    class Solution {
        public int movingCount(int threshold, int rows, int cols) {
            if (threshold < 0 || rows <= 0 || cols <= 0) {
                return 0;
            }
            return doMoving(threshold, rows, cols, 0, 0, new boolean[rows][cols]);
        }

        private int doMoving(int threshold, int rows, int cols, int curRow, int curCol, boolean[][] visited) {
            int count = 0;
            if (checkPosition(threshold, rows, cols, curRow, curCol, visited)) {
                visited[curRow][curCol] = true;
                count += 1; //当前节点
                count += doMoving(threshold, rows, cols, curRow - 1, curCol, visited);          // 上
                count += doMoving(threshold, rows, cols, curRow + 1, curCol, visited);          // 下
                count += doMoving(threshold, rows, cols, curRow, curCol - 1, visited);          // 左
                count += doMoving(threshold, rows, cols, curRow, curCol + 1, visited);          // 右
            }

            return count;
        }

        private boolean checkPosition(int threshold, int rows, int cols, int curRow, int curCol, boolean[][] visited) {
            // 检查各个参数
            if (curRow < 0 || curRow >= rows || curCol < 0 || curCol >= cols || visited[curRow][curCol]) {
                return false;
            }

            // 判断行坐标和列坐标的位数之和是否大于k
            int sum = 0;
            while (curRow > 0 || curCol > 0) {
                sum += curRow % 10 + curCol % 10;
                curRow /= 10;
                curCol /= 10;
            }
            return sum <= threshold;
        }
    }
}
