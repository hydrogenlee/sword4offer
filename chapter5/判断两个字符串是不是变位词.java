package sword4offer.chapter5;

import java.util.HashMap;
import java.util.Map;

public class 判断两个字符串是不是变位词 {
    public static void main(String[] args) {
        Solution solution = new 判断两个字符串是不是变位词().new Solution();
        System.out.println(solution.isAnagram("evil", "live"));          // true
        System.out.println(solution.isAnagram("evil", "livee"));         // false
    }

    class Solution {
        // 在英语中，如果两个单词中出现的字母相同，并且每个字母出现的次数也相同，那么两个单词为变位词
        public boolean isAnagram(String str1, String str2) {
            if (str1 == null || str2 == null || str1.length() != str2.length()) {
                return false;
            }

            if (str1.length() == 0 && str2.length() == 0) {
                return true;
            }

            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str1.length(); i++) {
                if (!map.containsKey(str1.charAt(i))) {
                    map.put(str1.charAt(i), 1);
                } else {
                    map.put(str1.charAt(i), map.get(str1.charAt(i)) + 1);
                }
            }

            for (int i = 0; i < str2.length(); i++) {
                if (map.containsKey(str2.charAt(i)) && map.get(str2.charAt(i)) >= 1) {
                    if (map.get(str2.charAt(i)) == 1) {
                        map.remove(str2.charAt(i));
                    } else {
                        map.put(str2.charAt(i), map.get(str2.charAt(i)) - 1);
                    }
                } else {
                    return false;
                }
            }

            // 检查map的值是否全是0
            return map.isEmpty();
        }
    }
}
