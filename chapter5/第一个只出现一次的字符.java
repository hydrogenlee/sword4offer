package sword4offer.chapter5;

import java.util.HashMap;
import java.util.Map;

public class 第一个只出现一次的字符 {
    public static void main(String[] args) {
        Solution solution = new 第一个只出现一次的字符().new Solution();
        System.out.println(solution.firstNotRepeatingChar("abaccdeff"));
    }
    class Solution {
        // 返回的是位置
        public int firstNotRepeatingChar(String str) {
            if (str == null || str.length() == 0) {
                return -1;
            }

            Map<Character, Integer> map = new HashMap<>();
            char[] array = str.toCharArray();
            for (int i = 0; i < array.length; i++) {
                if (map.containsKey(array[i])) {
                    map.put(array[i], map.get(array[i]) + 1);
                } else {
                    map.put(array[i], 1);
                }
            }

            for (int i = 0; i < array.length; i++) {
                if (map.get(array[i]) == 1) {
                    return i;
                }
            }

            return -1;       // 查找失败，没有只出现一次的字符
        }
    }
}
