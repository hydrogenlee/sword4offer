package sword4offer.chapter5;

import java.util.HashSet;
import java.util.Set;

public class 删除字符串中重复出现的字符 {
    public static void main(String[] args) {
        System.out.println(deleteDupChars("google"));
    }

    private static String deleteDupChars(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        Set<Character> set = new HashSet<>();
        char[] array = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (!set.contains(array[i])) {
                set.add(array[i]);
                sb.append(array[i]);
            }
        }

        return sb.toString();
    }
}
