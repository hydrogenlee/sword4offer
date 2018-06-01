package sword4offer.chapter2;

public class 二维数组中的查找 {

    public static void main(String[] args) {

        int[][] array = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };

        System.out.println(Find(7, array));     // true
        System.out.println(Find(5, array));     // true

    }

    public static boolean Find(int target, int [][] array) {
        int rows = 0;
        int cols = array[0].length - 1;

        while(rows < array.length && cols >= 0){
            if(array[rows][cols] == target) {
                return true;
            } else if (array[rows][cols] < target) {
                rows++;
            } else {
                cols--;
            }
        }
        return false;
    }
}
