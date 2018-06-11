package sword4offer.chapter6;

public class 翻转单词顺序 {
    public static void main(String[] args) {
        Solution solution = new 翻转单词顺序().new Solution();
        System.out.println(solution.reverseSentence("I am a student."));        // student. a am I
    }

    class Solution {
        // 使用两次翻转，先翻转整个句子，然后再翻转单词
        public  String reverseSentence(String str) {
            if (str == null || str.length() <= 1) {
                return str;
            }

            char[] array = str.toCharArray();
            // 先翻转句子
            int start = 0;
            int end = array.length - 1;
            while (start < end) {
                swap(array, start++, end--);
            }
            // 然后翻转单词
            start = 0;
            end = 0;
            while (start < array.length) {
                if (end == array.length || array[end] == ' ') {
                    int tempStart = start;
                    int tempEnd = end - 1;
                    while (tempStart < tempEnd){
                        swap(array, tempStart++, tempEnd--);
                    }
                    start = end + 1;
                    end = start;
                    continue;
                }
                end++;
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
