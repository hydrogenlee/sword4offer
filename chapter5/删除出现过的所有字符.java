package sword4offer.chapter5;

import java.util.HashSet;
import java.util.Set;

public class 删除出现过的所有字符 {
    public static void main(String[] args) {
        System.out.println(deleteExistingChars("We are students. ", "aeiou"));
    }

    private static String deleteExistingChars(String original, String deleteChars) {
        if (original == null || original.length() == 0 || deleteChars == null || deleteChars.length() == 0) {
            return original;
        }

        Set<Character> deletedCharSet = new HashSet<>();
        for (int i = 0; i < deleteChars.length(); i++) {
            deletedCharSet.add(deleteChars.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        char[] originalCharArray = original.toCharArray();
        for (int i = 0; i < originalCharArray.length; i++) {
            if (!deletedCharSet.contains(originalCharArray[i])) {
                sb.append(originalCharArray[i]);
            }
        }

        return sb.toString();
    }
}
