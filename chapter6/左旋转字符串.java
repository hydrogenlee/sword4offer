package sword4offer.chapter6;

public class 左旋转字符串 {
    public static void main(String[] args) {
        Solution solution = new 左旋转字符串().new Solution();
        System.out.println(solution.leftRotateString("abcdefg", 6));
    }

    class Solution {
        public String leftRotateString(String str,int n) {
            // 旋转0位和旋转n位，就是本身自己
            if (str == null || str.length() == 0 || n <= 0 || n >= str.length()) {
                return str;
            }

            char[] array = str.toCharArray();

            // 首先先旋转这个字符串
            int start = 0;
            int end = str.length() - 1;
            while (start < end) {
                swap(array, start++, end--);
            }
            // 然后按照str.length() - n位置将字符串分为两个字符串，分别旋转
            start = 0;
            end = str.length() - n - 1;
            while (start < end) {
                swap(array, start++, end--);
            }

            start = str.length() - n;
            end = str.length() - 1;
            while (start < end) {
                swap(array, start++, end--);
            }

            return new String(array);
        }

        private void swap(char[] array, int index1, int index2) {
            if (array == null || array.length == 0 || index1 < 0 || index1 >= array.length ||
                    index2 < 0 || index2 >= array.length || index1 == index2) {
                return;
            }
            char temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }
    }

}
