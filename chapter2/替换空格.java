package sword4offer.chapter2;

public class 替换空格 {
    public static void main(String[] args) {
        Solution solution = new 替换空格().new Solution();
        System.out.println(solution.replaceSpaceUsingStringBuilder(new StringBuffer("We are happy.")));
        System.out.println(solution.replaceSpaceInReverseOrder(new StringBuffer("We are happy.")));
    }

    class Solution {
        public String replaceSpaceUsingStringBuilder(StringBuffer str) {
            if (str == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    sb.append("%20");
                } else {
                    sb.append(str.charAt(i));
                }
            }
            return sb.toString();
        }

        public String replaceSpaceInReverseOrder(StringBuffer str) {
            if (str == null || str.length() == 0) {
                return null;
            }

            // 查找空格的个数
            int numOfSpace = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    numOfSpace++;
                }
            }

            char[] array = new char[str.length() + numOfSpace * 2];
            int indexOfNew = array.length - 1;
            int indexOfOrigin = str.length() - 1;
            while(indexOfOrigin >= 0) {
                if (str.charAt(indexOfOrigin) == ' ') {
                    array[indexOfNew--] = '0';
                    array[indexOfNew--] = '2';
                    array[indexOfNew--] = '%';
                } else {
                    array[indexOfNew--] = str.charAt(indexOfOrigin);
                }
                indexOfOrigin--;
            }

            return new String(array);
        }
    }
}
