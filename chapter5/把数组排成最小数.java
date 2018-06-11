package sword4offer.chapter5;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 把数组排成最小数 {
    public static void main(String[] args) {
        Solution solution = new 把数组排成最小数().new Solution();
        System.out.println(solution.printMinNumber(new int[]{3, 32, 321}));          // 321323
        System.out.println(solution.printMinNumber(new int[]{3, 34, 321}));          // 321334
        System.out.println(solution.printMinNumber(new int[]{1, 32, 321}));          // 132132
    }

    class Solution {
        // 这个方法比较快，没有直接使用字符串的拼接操作，而是通过一位一位的比较字符数组
        public String printMinNumber(int [] numbers) {
            if (numbers == null || numbers.length == 0) {
                return "";
            }
            // 排序 一位一位的进行比较，如果相等继续比较下一位，
            // 如果一个数字已经到达结尾，按照最后一个数字进行比较，
            // 只有两个数字同时到达结尾时，才返回
            // 先转为String再排序
            List<char[]> list = new ArrayList<>();
            for (int number : numbers) {
                list.add(Integer.toString(number).toCharArray());
            }

            list.sort(new Comparator<char[]>() {
                @Override
                public int compare(char[] o1, char[] o2) {
                    int i = 0;
                    int j = 0;
                    while (i < o1.length || j < o2.length) {
                        char curOfO1 = i == o1.length ? o1[i - 1] : o1[i];
                        char curOfO2 = j == o2.length ? o2[j - 1] : o2[j];
                        if (curOfO1 == curOfO2) {
                            i = i == o1.length ? i : i + 1;
                            j = j == o2.length ? j : j + 1;
                        } else if (curOfO1 > curOfO2) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                    return 0;
                }
            });

            StringBuilder sb = new StringBuilder();
            for (char[] number : list) {
                sb.append(number);
            }
            return sb.toString();
        }


        public String printMinNumber2(int[] numbers) {
            if (numbers == null || numbers.length == 0) {
                return "";
            }
            // 排序 将两个数组分别连接起来，然后再比较
            List<Integer> list = new ArrayList<>();
            for (int number : numbers) {
                list.add(number);
            }

            list.sort((o1, o2) -> (String.valueOf(o1) + o2).compareTo(String.valueOf(o2) + o1));

            StringBuilder sb = new StringBuilder();
            for (Integer number : list) {
                sb.append(number);
            }
            return sb.toString();
        }
    }
}
